// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cms.proto

package com.ubb.cms.generated;

public final class cmsProto {
  private cmsProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cms_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cms_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cms_HelloReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cms_HelloReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cms_GetUsersRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cms_GetUsersRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cms_UserDto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cms_UserDto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cms_GetEditionsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cms_GetEditionsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cms_EditionDto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cms_EditionDto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cms_GetEditionsReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cms_GetEditionsReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cms_ConferenceDto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cms_ConferenceDto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\tcms.proto\022\003cms\032\037google/protobuf/timest" +
      "amp.proto\"\034\n\014HelloRequest\022\014\n\004name\030\001 \001(\t\"" +
      "\035\n\nHelloReply\022\017\n\007message\030\001 \001(\t\"\021\n\017GetUse" +
      "rsRequest\"t\n\007UserDto\022\n\n\002id\030\001 \001(\003\022\014\n\004name" +
      "\030\002 \001(\t\022\020\n\010password\030\003 \001(\t\022\017\n\007surname\030\004 \001(" +
      "\t\022\013\n\003tag\030\005 \001(\t\022\020\n\010username\030\006 \001(\t\022\r\n\005emai" +
      "l\030\007 \001(\t\"\024\n\022GetEditionsRequest\"\241\002\n\nEditio" +
      "nDto\022\n\n\002id\030\001 \001(\003\022\014\n\004name\030\006 \001(\t\0221\n\rbeginn" +
      "ingDate\030\002 \001(\0132\032.google.protobuf.Timestam" +
      "p\022.\n\nendingDate\030\003 \001(\0132\032.google.protobuf.",
      "Timestamp\0221\n\rfinalDeadline\030\005 \001(\0132\032.googl" +
      "e.protobuf.Timestamp\022;\n\027paperSubmissionD" +
      "eadline\030\007 \001(\0132\032.google.protobuf.Timestam" +
      "p\022&\n\nconference\030\010 \001(\0132\022.cms.ConferenceDt" +
      "o\"4\n\020GetEditionsReply\022 \n\007Edition\030\001 \003(\0132\017" +
      ".cms.EditionDto\")\n\rConferenceDto\022\n\n\002id\030\001" +
      " \001(\003\022\014\n\004name\030\002 \001(\t2\263\001\n\nCmsService\0220\n\010Say" +
      "Hello\022\021.cms.HelloRequest\032\017.cms.HelloRepl" +
      "y\"\000\0222\n\010GetUsers\022\024.cms.GetUsersRequest\032\014." +
      "cms.UserDto\"\0000\001\022?\n\013GetEditions\022\027.cms.Get",
      "EditionsRequest\032\025.cms.GetEditionsReply\"\000" +
      "B4\n\025com.ubb.cms.generatedB\010cmsProtoP\001\252\002\016" +
      "Cmc.sGeneratedb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
        }, assigner);
    internal_static_cms_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_cms_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cms_HelloRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_cms_HelloReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_cms_HelloReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cms_HelloReply_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_cms_GetUsersRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_cms_GetUsersRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cms_GetUsersRequest_descriptor,
        new java.lang.String[] { });
    internal_static_cms_UserDto_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_cms_UserDto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cms_UserDto_descriptor,
        new java.lang.String[] { "Id", "Name", "Password", "Surname", "Tag", "Username", "Email", });
    internal_static_cms_GetEditionsRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_cms_GetEditionsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cms_GetEditionsRequest_descriptor,
        new java.lang.String[] { });
    internal_static_cms_EditionDto_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_cms_EditionDto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cms_EditionDto_descriptor,
        new java.lang.String[] { "Id", "Name", "BeginningDate", "EndingDate", "FinalDeadline", "PaperSubmissionDeadline", "Conference", });
    internal_static_cms_GetEditionsReply_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_cms_GetEditionsReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cms_GetEditionsReply_descriptor,
        new java.lang.String[] { "Edition", });
    internal_static_cms_ConferenceDto_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_cms_ConferenceDto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cms_ConferenceDto_descriptor,
        new java.lang.String[] { "Id", "Name", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
