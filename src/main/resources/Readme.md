cd src/main
thrift -r -gen java  -out java/ thrift/models.thrift
thrift -r -gen java  -out java/ thrift/service.thrift