## PART A feign
- API Tests by mocking Feign clients using Wiremock (工序7 发送调用FeignClient)

#### How to Run  

##### 1. For API Tests by mocking Feign clients using Wiremock
Run directly

## PART B test
- 工序 1 正常http请求
- 工序2 接收MQ
- 工序3 happy path的业务逻辑
- 工序4 数据库查询方法
- 工序5 数据库保存
- 工序6 发送MQ
- Before mocking Feign clients Test (For reference only, not used in the project)
- Integration Test

#### How to Run

Run directly

## Problem
1.test events were not received

Solution: File -> Settings ->Build,Execution, Deployment -> Build Tools -> Gradle

Run test using: dropdown selected option was: Gradle(default) changed it to IntelliJ IDEA

