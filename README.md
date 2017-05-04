# CMS-Backend

* Copy ```repository/src/main/resources/database.properties.dist``` to ```repository/src/main/resources/database.properties```
* Modify the newly created file with your database credentials (it will not be tracked with git)
* After modifying file ```grpc-common/src/main/proto/cms.proto``` run generateProto task using gradle