# CMS-Backend

* Copy ```repository/src/main/resources/database.properties.dist``` to ```repository/src/main/resources/database.properties```
* Modify the newly created file with your database credentials (it will not be tracked with git)
* After modifying file ```grpc-common/src/main/proto/cms.proto``` run generateProto task using gradle

If cannot run ```com.ubb.mpp.cms.server.CmsServerMain::main``` try to get the last version of the code
by running ```git pull origin master``` after you've commited any local changes

    - Run ```com.ubb.mpp.cms.server.CmsServerMain::main``` to get the server running on port 50051
    - Run ```com.ubb.mpp.cms.client.CliClientMain::main``` to see that the client correctly connects to the server and can call some methods on it

If the project still cannot be ran, then clone the repo in another directory ```git clone git@github.com:FilipMarusca/CMS-Backend.git```
and import it again into intellij