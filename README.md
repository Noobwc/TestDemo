首先要部署好build.gradle环境，然后直接在测试类中运行即可，运行若失败可参考Problem

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

## Question (最好新建一个测试类)

### 当前必须掌握的

工序 1 正常http请求

given Spy ConsumerService getConsumerById方法

when Fake Http ConsumerController 方法getConsumerById并传入json [id]

then 验证ConsumerService 被正常调用，且参数为[consumer]，且返回值为200

工序 1 正常http请求

given Spy ProducerService addProducer方法

when Fake Http ProducerController方法addProducer方法并传入json [producer]

then 验证ProducerService被正常调用，且参数为[producer]，且返回值为200


工序2 接收MQ

given Spy ConsumerService updateRequest方法

when BusServiceHandler 方法onGetUpdateConsumerRequest并传入json []

then 验证ConsumerService 被正常调用，且参数为[]



工序3 service的业务逻辑

given Spy ConsumerRepository

when ConsumerService 层方法getConsumerById调用，调用参数id

then 验证ConsumerRepository 被正常调用，且验证调用参数后结果为consumerDTO



工序4 数据库查询方法

given Fake DB，增加Entity Consumer Stub 待查询数据

when ConsumerRepository 层方法findConsumerByConsumerName 调用Dummy 查询参数

then 验证返回值与Stub数据相同



工序5 数据库保存

given Fake DB，增加Entity Producer Stub 待查询数据

when ProducerRepository 层方法findAllProducer 调用Dummy 查询待保存数据

then 验证数据被正常保存



工序6 发送MQ

given Spy BusService Sender

when ConsumerMessageRepository层方法sendExpenseCalenderMessage调用Dummy 查询参数

then 验证jmsTemplate发送数据与Dummy相同


### 暂时为次要掌握的

工序7 发送调用FeignClient

given Spy IBookClient的 /book/12345 返回statue为404

when BookController 层方法bookSearch 调用”12345"查询参数

then 验证FeignClient发送数据与默认返回值相同



Integration Test

given Fack DB Mock Other Service

when Fack http 调用 url :/consumers/{id}

then 验证返回值和数据库数据
