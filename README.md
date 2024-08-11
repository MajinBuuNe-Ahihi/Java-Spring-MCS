## Java*Spring*MCS
Project có javacore * spring * microservices

##AOP
có thể chèn vào các function khác đang hoạt dhhong
định nghĩa các aspect
@Before
@Around
@After
spring*boot*start*aop
các aspect là component
lấy các đường dẫn controller
khởi tạo class
với @Aspect và @Component

public class Logger {
//define name for pointcut
@Pointcut("within(@url))
public void controllerMethod(){}

@Around("excution(* url...)") *> POINTCUT
public Object acitvity(ProceedingJoinPoint pjp) {
 //TO DO SOME THING

 Object result = prj.proceed(); // thực hiện method gốc
}
}

##xử lý exception chung 
@RestcontrollerAdvice
public class ExHandler {
@ExceptionHandler(Exception.class)
public ResponseEnity<> handleGeneralException(Exception ex) {}
}

tư duy tạo 1 objectresponse chung và xử lý chung trong đấy

##Kafka
![image](https://github.com/user*attachments/assets/da4af034*c120*43ca*b32a*cdbff61c212f)

Kafka Cluster là 1 cụm casc broker Kafka là vieccje cùng nhau để cung cấp một hê thống phân tán có độ tin cậy cao và khả năng mở rộng để xử lý dữ liệu streaming. cụm Kafka đảm bảo rằng các bản sao dữ liệu(replicas) được phân phối  trên nhiều brocker đc cung cấp tính sẵn sàng cao và khả năng chịu lỗi.
Các thành phần chính: 
Broker: 
`*` brocker chịu trách nghiệm lưu trữ dữ liệu, xử lý các yêu cầu từ producer, consumer và quản lý dữ liệu
`*` mỗi broker trong cluster được xác định bằng 1 id duy nhất
Topic:
`*` Mỗi topic được chia nhiều partrition. mỗi patrition là 1 log đơn giản, các bản ghi đc thêm vào tuần tự
`*` Phân vùng cho phép kafka phân phối dữ liệu trên nhiều broker, giúp tăng khả năng xử lý song song và đảm bảo rằng khả năng mở rộng
Repliction:
`*` kafka cung cấp khả năng sao chép dữ liệu bằng cách duy nhiều bản sao (replicas) của mỗi partrition trên các broker khác nhau điều này đảm bảo rằng nếu 1 broker gặp sự cố dữ liệu vẫn có sẵn trên các broker khác.
zooKepker
`*` Kafka sử dụng **Apache Zookeepr** để quản lý metadata của cluster và thực hiện nhiệm vụ quan trọng như theo dõi trạng thái của cá broker, leader election cho các partrition và lưu trữ cấu hình.
**Producer và Consumer**:
`*` Producer: các ứng dụng gửi dữ liệu vào các topic trong Kafka
`*` Consumer: các ứng dựng đọc dữ liệu từ các topic
**Cách hoạt động**:
  **Producer** *> gửi dữ liệu tới Kafka Cluster: khi producer gửi dữ liệu, Kafka cluster sẽ xác định patitrion tích hợp cho dữ liệu đó dựa trên key hoặc thuật toán round*robin
  *> dữ liệu được gửi tới các broker tương ứng với partitrion đó
  **Replication** *> mỗi replication  có 1 leader project *> chịu trách nghiệm đọc và ghi. các brocker khác sẽ là follower và sao chép dữ liệu từ leader
  **Consumer** xử lý dữ liệu từ Kafka cluster đọc dữ lieuj từ các topic theo partitrion đảm bảo dữ liệu được xử lý theo đúng dữ liệu của mỗi patitrion
  **Zookeeper** quản lý trạng thái của Kafka cluster *> theo dõi thôn gtin về broker, topics và phân vùng. nó cũng xử lý việc leader election khi 1 broker bị lỗi đảm bảo rằng broker khác sẽ trở thành leaer cho các partitrion mà nó chịu trách nhiệm.

** Tính Sẵn Sàng Cao và Khả Năng Chịu Lỗi:**
`*` Leader Election: Nếu broker nào đó bị lỗi, Zookeeper sẽ giúp chọn một leader mới cho các partition mà broker đó quản lý.
`*` Replication: Nếu một broker bị lỗi, dữ liệu vẫn có sẵn trên các broker khác nhờ vào việc sao chép partition.
**Triển Khai Kafka Cluster:**
**Cấu hình Kafka Cluster:**
`*`Thiết lập nhiều broker trên các server khác nhau.
Cấu hình replication factor cho mỗi topic để đảm bảo dữ liệu được sao chép trên nhiều broker.
**Cấu hình Zookeeper:**

`*`Thiết lập một cụm Zookeeper để quản lý Kafka Cluster. Số lượng Zookeeper server nên là số lẻ để đạt được quorum khi có lỗi.
**Monitor và quản lý:**

`*`Sử dụng các công cụ giám sát để theo dõi tình trạng của cluster và thực hiện bảo trì khi cần thiết.
**Lợi Ích của Kafka Cluster:**
`*`Khả năng mở rộng: Kafka Cluster có thể dễ dàng mở rộng bằng cách thêm nhiều broker.
`*`Độ tin cậy cao: Nhờ vào replication và Zookeeper, Kafka Cluster có thể xử lý lỗi mà không mất dữ liệu.
`*`Hiệu suất cao: Kafka có thể xử lý một lượng lớn dữ liệu với độ trễ thấp, phù hợp cho các hệ thống yêu cầu xử lý dữ liệu thời gian thực.
Kafka Cluster là một phần quan trọng trong các hệ thống phân tán hiện đại, đặc biệt là trong các ứng dụng cần xử lý và phân phối dữ liệu streaming với độ tin cậy cao.
#Zookeper
Zookeeper là một dịch vụ quản lý tập trung, thường được sử dụng để cung cấp các chức năng như đồng bộ hóa, quản lý cấu hình, và điều phối dịch vụ trong các hệ thống phân tán. Apache Kafka, cùng với nhiều hệ thống khác như Hadoop, HBase, và Apache Storm, sử dụng Zookeeper để quản lý và điều phối các hoạt động trong cụm (cluster).

**Cách Hoạt Động của Zookeeper**:
**Nodes và Znodes**:

Zookeeper tổ chức dữ liệu dưới dạng một cấu trúc cây, trong đó mỗi nhánh và lá được gọi là một "znode". Znode có thể chứa dữ liệu và có thể được quan sát bởi các client để phát hiện thay đổi.
**Session và Watchers:**

Mỗi client khi kết nối tới Zookeeper sẽ mở một phiên làm việc (session). Trong phiên này, client có thể thiết lập các watcher để theo dõi các thay đổi trên các znode cụ thể. Khi có thay đổi, Zookeeper sẽ gửi thông báo đến các client đã thiết lập watcher.
**Quorum và Write Consistency**:

Zookeeper sử dụng một cơ chế gọi là "quorum" để đảm bảo tính nhất quán và khả năng chịu lỗi. Quorum yêu cầu sự đồng thuận từ phần lớn (đa số) các node trong cụm Zookeeper để thực hiện các thay đổi, giúp đảm bảo rằng không có dữ liệu nào bị mất ngay cả khi một số node gặp sự cố.

**Triển Khai Zookeeper**:
**Zookeeper Ensemble**:
Zookeeper thường được triển khai dưới dạng một cụm nhiều server, gọi là "ensemble". Để đảm bảo độ tin cậy, số lượng server trong ensemble thường là số lẻ (3, 5, hoặc 7).
Trong một ensemble, nếu một server gặp sự cố, các server còn lại có thể tiếp tục hoạt động mà không ảnh hưởng đến toàn bộ hệ thống.
**Quản lý và Giám sát:**

Zookeeper cung cấp các công cụ để giám sát và quản lý cluster, như zkCli.sh để tương tác với Zookeeper, và các công cụ giám sát như Prometheus, Grafana để theo dõi hiệu suất và tình trạng của cluster.
