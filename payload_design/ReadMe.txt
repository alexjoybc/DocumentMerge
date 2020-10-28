pdf_merge_request object 
------------------------

options: 
	forcePDFAOnload: if the incoming document is determined to be XFA type, downshift to PDF/A type before merging. 
	
documents: 
	id: not sure if we need this. 
	mediaType: First iteration will only support pdf mediaType. Future versions may support MS Word, etc. 
	placement: page index in output. 1 = first page, etc. 
	data: Base64 encoded document. 	
	

pdf_merge_response_success object (enveloped)
--------------------------------------------

resp: success 
data
    document: Base64 encoded reponse
    mimeType: Mime type of output
}


pdf_merge_response_failure object (enveloped)
--------------------------------------------
resp: fail 
error: 
    message: Reason for failure
    httpStatus: Http status of response. 
}

	