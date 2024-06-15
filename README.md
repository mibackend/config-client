/api/config/all：返回当前profile从git仓库读取的配置信息。

示例：
当指定spring.profiles.active为prod时，返回全局配置文件application.yml、生产环境的全局配置文件application-prod.yml和config-client 服务的通用配置文件、config-client 服务在开发环境下的配置文件

{
  "Config Server git@github.com:mibackend/quiz-pro-react_config-service.git/config/config-client-prod.yml:11:13": {
    "datasource.username": "prod_user"
  },
  "Config Server git@github.com:mibackend/quiz-pro-react_config-service.git/config/application-prod.yml:4:19": {
    "spring.config.activate.on-profile": "prod"
  },
  "Config Server git@github.com:mibackend/quiz-pro-react_config-service.git/config/application.yml:8:18": {
    "management.endpoints.web.exposure.include": "health, info"
  },
  "Config Server git@github.com:mibackend/quiz-pro-react_config-service.git/config/config-client-prod.yml:8:13": {
    "custom.property": "prod-value"
  },
  "Config Server git@github.com:mibackend/quiz-pro-react_config-service.git/config/application-prod.yml:13:18": {
    "management.endpoints.web.exposure.include": "health, info"
  },
  "Config Server git@github.com:mibackend/quiz-pro-react_config-service.git/config/application.yml:3:11": {
    "logging.level.root": "INFO"
  },
  "Config Server git@github.com:mibackend/quiz-pro-react_config-service.git/config/config-client-prod.yml:4:19": {
    "spring.config.activate.on-profile": "prod"
  },
  "Config Server git@github.com:mibackend/quiz-pro-react_config-service.git/config/config-client-prod.yml:10:8": {
    "datasource.url": "jdbc:mysql://localhost:3306/prod_db"
  },
  "Config Server git@github.com:mibackend/quiz-pro-react_config-service.git/config/config-client.yml:6:13": {
    "custom.property": "some-common-value"
  },
  "Config Server git@github.com:mibackend/quiz-pro-react_config-service.git/config/config-client.yml:3:11": {
    "spring.application.name": "config-client"
  },
  "Config Server git@github.com:mibackend/quiz-pro-react_config-service.git/config/application-prod.yml:7:11": {
    "logging.level.root": "ERROR"
  },
  "Config Server git@github.com:mibackend/quiz-pro-react_config-service.git/config/config-client-prod.yml:12:13": {
    "datasource.password": "prod_password"
  }
}
