## DCI建模, 解决DDD建模的缺点

充血模型缺点: 上帝类, 模块耦合

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
