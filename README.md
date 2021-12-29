## DCI建模, 解决DDD建模的缺点

### 案例

以一个普通人的经典场景进行建模
人: 身份证, 学生卡, 工卡, 银行卡
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
[路径](src/main/kotlin/ddd)

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

#### DDD建模的问题
- 上帝类: Person类包含了太多的职责, 违背了单一职责的原则, 降低维护性
- 模块耦合: School, Company, Park, Home, 都是相互独立的, 但它们都依赖了 Person实体, 导致School可以调用Company场景中的方法, 违背了接口隔离原则

