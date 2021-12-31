## DCI建模, 解决DDD建模的缺点

DCI实现往往需要借助编程语言的特性, 例如Dart语言的Mixin, Go语言的结构体组合等.

本项目演示了利用kotlin代理特性对DCI建模的实现

[极简示例](src/main/kotlin/simple/main.kt)

### 案例

以一个普通人的经典场景进行建模

人:

- 身份证
- 学生卡
- 工卡
- 银行卡

场景与行为:

- 家
    - 吃饭
    - 睡觉
    - 玩游戏
- 学校
    - 学习
    - 考试
- 公司
    - 上班
    - 下班
- 公园
    - 游玩
    - 购票

### 使用DDD建模

- aggregate [聚合根](src/main/kotlin/ddd/aggregate.kt)
    - company
    - home
    - park
    - school
- entity [实体](src/main/kotlin/ddd/entity.kt)
    - people
- vo [值对象](src/main/kotlin/ddd/vo.kt)
    - account
    - identity_card
    - student_card
    - work_card

[演示](src/main/kotlin/ddd/Test.kt)

#### DDD建模的问题

- 上帝类: Person类包含了太多的职责, 违背了单一职责的原则, 降低维护性
- 模块耦合: School, Company, Park, Home, 都是相互独立的, 但它们都依赖了 Person实体, 导致School可以调用Company场景中的方法, 违背了接口隔离原则

### DCI建模

#### Data 数据层

描述系统有哪些领域概念及其之间的关系，该层专注于领域对象的确立和这些对象的生命周期管理及关系， 让程序员站在对象的角度思考系统，从而让“系统是什么”更容易被理解。

> 数据/领域对象, 用于描述系统"是什么", 相当于DDD中的Domain层

- data [数据](src/main/kotlin/dci/data.kt)
    - IdentityCard
    - StudentCard
    - WorkerCard
    - BankCard

#### Context 场景层

是尽可能薄的一层。Context往往被实现得无状态，只是找到合适的role，让role交互起来完成业务逻辑即可。 
但是简单并不代表不重要，显示化context层正是为人去理解软件业务流程提供切入点和主线。

> 上下文, 即系统的业务处理流程,描述系统"怎么做", 相当于DDD中的Application层

- context [场景](src/main/kotlin/dci/context.kt)
    - Home
    - School
    - Company
    - Park

#### Interactive 交互层

主要体现在对role的建模，role是每个context中复杂的业务逻辑的真正执行者，体现系统"做什么"。 role所做的是对行为进行建模，它联接了context和领域对象。
由于系统的行为是复杂且多变的，role使得系统将稳定的领域模型层和多变的系统行为层进行了分离，由role专注于对系统行为进行建模。 该层往往关注于系统的可扩展性，更加贴近于软件工程实践，在面向对象中更多的是以类的视角进行思考设计。

> Object 领域对象通过组合/继承 将Role继承起来, 具备了扮演角色的能力

- object [对象](src/main/kotlin/dci/object.kt)
    - people

> Role 是面向Context的, 因为特定业务行为只有在特定业务场景下才会有意义. 通过Role将领域对象的方法拆分出去, 避免出现上帝类

- role [角色](src/main/kotlin/dci/role.kt)
    - HumanRole
    - StudentRole
    - WorkerRole
    - TouristRole

[演示](src/main/kotlin/dci/Test.kt)

#### 目录结构

- application

- domain
  > (聚合根被替换为 data和interaction)
  > 定义领域模型，不仅包括领域对象及其之间关系的建模，还包括对象的角色role的显式建模
    - object  (data)
    - role (interaction)
- context
  > (新增一个路径, 与domain平级)
  > 以上下文为单位，将Domain层的领域对象cast成合适的role，让role交互起来完成业务逻辑。

- infra
  > 为其他层提供通用的技术能力：业务平台，编程框架，持久化机制，消息机制，第三方库的封装，通用算法，等等。

#### DCI总结

对 领域对象(Object) 在每个业务场景(Context) 中扮演的角色(Role) 进行建模



> 相关参考 http://dockerone.com/article/9664