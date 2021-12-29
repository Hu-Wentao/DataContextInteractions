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

> 数据/领域对象, 用于描述系统"是什么", 相当于DDD中的Domain层

- data [数据](src/main/kotlin/dci/data.kt)
    - IdentityCard
    - StudentCard
    - WorkerCard
    - BankCard

#### Context 场景层

> 上下文, 即系统的业务处理流程,描述系统"怎么做", 相当于DDD中的Application层

- context [场景](src/main/kotlin/dci/context.kt)
    - Home
    - School
    - Company
    - Park

#### Interactive 交互层

对 领域对象(Object) 在每个业务场景(Context) 中扮演的角色(Role) 进行建模

> Object 领域对象通过组合/继承 将Role继承起来, 具备了扮演角色的能力

- object [对象](src/main/kotlin/dci/object.kt)
    - people

> Role 代表业务行为(做什么), Role之间的交互即业务流程
> Role 是面向Context的, 因为特定业务行为只有在特定业务场景下才会有意义. 通过Role将领域对象的方法拆分出去, 避免出现上帝类

- role [角色](src/main/kotlin/dci/role.kt)
    - HumanRole
    - StudentRole
    - WorkerRole
    - TouristRole

[演示](src/main/kotlin/dci/Test.kt)