# MySpringCloud
第一个SpringCloud工程


# dept
dept-service-port : 8001
dept-web-port : 80


?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false

#客户端注册进eureka服务列表
eureka:
  client:
    #register-with-eureka: false
    #fetch-registry: false
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka,http://eureka7003.com:7003/eureka
  instance:
    #服务实例名称修改
    instance-id: study-springcloud-dept8001
    #访问路径显示IP地址
    prefer-ip-address: true
    
    
    
    
info:
  app.name: study-springcloud-micoservices
  company.name: www.gxs.com
  build.artifactId: ${project.artifactId}
  build.version: ${project.version}
