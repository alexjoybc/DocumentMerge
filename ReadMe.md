## Document Merge Service

A RESTful Document Merge Service. 

## Swagger-UI endpoint
http://localhost:8082/docmerge/swagger-ui.html

## API Endpoints

Basic Merge
http://localhost:8082/docmerge/merge/{correlationId}

## Building AEM tools with Maven
https://helpx.adobe.com/ca/experience-manager/6-3/sites/developing/using/ht-projects-maven.html
https://helpx.adobe.com/aem-forms/6/aem-livecycle-connector.html#AdobeLiveCycleAssemblerClientbundle

## AEM engine
AEM version : Sarcee, v6.2.0, GM

## Request Example

{
   "options":{
      "forcePDFAOnLoad": true,  	<-- Forces XFA document types to PDF/A prior to merge. AEM cannot merge XFA documents (at present)
      "createToC": true  			<-- Creates first page as Table of Contents.
   },
   "documents":[
      {
         "id":"optional",			<-- Document ID. Currently not used by may be used in Future as Bookmark label.
         "docType":"pdf",			<-- must be 'pdf'. No other document types supported yet.
         "order":1,					<-- Output order. Starts with 1. Second document is 2, and on. 
         "data":"SGVsbG9Xb3JsZA==" 	<-- Base64 encoded input document (PDF).
      },
      {
         "id":"optional",
         "docType":"pdf",
         "order":2,
         "data":"SGVsbG9Xb3JsZA=="
      }
   ]
}

