/**
 * 
 */
package com.example.demo.secTest1;

import java.io.InputStream;
import java.util.List;

import org.apache.olingo.commons.api.data.ContextURL;
import org.apache.olingo.commons.api.data.Entity;
import org.apache.olingo.commons.api.data.EntityCollection;
import org.apache.olingo.commons.api.data.Property;
import org.apache.olingo.commons.api.edm.EdmEntitySet;
import org.apache.olingo.commons.api.edm.EdmEntityType;
import org.apache.olingo.commons.api.format.ContentType;
import org.apache.olingo.commons.api.http.HttpHeader;
import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataApplicationException;
import org.apache.olingo.server.api.ODataLibraryException;
import org.apache.olingo.server.api.ODataRequest;
import org.apache.olingo.server.api.ODataResponse;
import org.apache.olingo.server.api.ServiceMetadata;
import org.apache.olingo.server.api.processor.EntityCollectionProcessor;
import org.apache.olingo.server.api.serializer.EntityCollectionSerializerOptions;
import org.apache.olingo.server.api.serializer.ODataSerializer;
import org.apache.olingo.server.api.serializer.SerializerResult;
import org.apache.olingo.server.api.uri.UriInfo;
import org.apache.olingo.server.api.uri.UriResource;
import org.apache.olingo.server.api.uri.UriResourceEntitySet;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.controller.EntidadNuevaController;
import com.example.demo.model.EntidadNueva;
import com.example.demo.repo.EntidadNuevaRepo;

/**
 * @author Emmanuel Neiza
 *
 */
public class DBEntityCollectionProcessor implements EntityCollectionProcessor {
	private OData odata;
	private ServiceMetadata serviceMetadata;
	@Autowired
	EntidadNuevaRepo entidadRepo;
	/* (non-Javadoc)
	 * @see org.apache.olingo.server.api.processor.Processor#init(org.apache.olingo.server.api.OData, org.apache.olingo.server.api.ServiceMetadata)
	 */
	@Override
	public void init(OData odata, ServiceMetadata serviceMetadata) {
		// TODO Auto-generated method stub
		this.odata = odata;
		this.serviceMetadata = serviceMetadata;
	}

	/* (non-Javadoc)
	 * @see org.apache.olingo.server.api.processor.EntityCollectionProcessor#readEntityCollection(org.apache.olingo.server.api.ODataRequest, org.apache.olingo.server.api.ODataResponse, org.apache.olingo.server.api.uri.UriInfo, org.apache.olingo.commons.api.format.ContentType)
	 */
	@Override
	public void readEntityCollection(ODataRequest request, ODataResponse response, UriInfo uriInfo, ContentType responseFormat)
			throws ODataApplicationException, ODataLibraryException {
		  List<UriResource> resourcePaths = uriInfo.getUriResourceParts();
		  UriResourceEntitySet uriResourceEntitySet = (UriResourceEntitySet) resourcePaths.get(0); // in our example, the first segment is the EntitySet
		  EdmEntitySet edmEntitySet = uriResourceEntitySet.getEntitySet();

		  // 2nd: fetch the data from backend for this requested EntitySetName
		  // it has to be delivered as EntitySet object
		 
		  EntityCollection entitySet = getData("");
		  System.out.println("Estoy Aca"+entitySet.toString());
		  // 3rd: create a serializer based on the requested format (json)
		  ODataSerializer serializer = odata.createSerializer(responseFormat);

		  // 4th: Now serialize the content: transform from the EntitySet object to InputStream
		  EdmEntityType edmEntityType = edmEntitySet.getEntityType();
		  ContextURL contextUrl = ContextURL.with().entitySet(edmEntitySet).build();

		  final String id = request.getRawBaseUri() + "/" + edmEntitySet.getName();
		  EntityCollectionSerializerOptions opts = EntityCollectionSerializerOptions.with().id(id).contextURL(contextUrl).build();
		  SerializerResult serializerResult = serializer.entityCollection(serviceMetadata, edmEntityType, entitySet, opts);
		  InputStream serializedContent = serializerResult.getContent();

		  // Finally: configure the response object: set the body, headers and status code
		  response.setContent(serializedContent);
		  response.setStatusCode(HttpStatusCode.OK.getStatusCode());
		  response.setHeader(HttpHeader.CONTENT_TYPE, responseFormat.toContentTypeString());

	}

	

	// loop over List<Foo> converting each instance of Foo into and Olingo Entity 
	private EntityCollection makeEntityCollection(List<EntidadNueva> fooList){
	    EntityCollection entitySet = new EntityCollection();

	    for (EntidadNueva foo: fooList){
	        entitySet.getEntities().add(createEntity(foo));
	    }

	    return entitySet;
	} 
	 // Convert instance of Foo object into an Olingo Entity
	 private Entity createEntity(EntidadNueva foo){
	    Entity tmpEntity = new Entity()
	            .addProperty(new Property("int","id"))
	            .addProperty(new Property("string","name"))
	            .addProperty(new Property("string","lastname"));
	    return tmpEntity;
	}
	 private List<EntidadNueva> getAllFoos(){
		 System.out.println("Antes");
		 EntidadNuevaController ex = null;
	
		 List<EntidadNueva> foos =entidadRepo.findAll();
		 System.out.println(foos.toString());
		 return foos;
	 }

	 public EntityCollection getData(String edmEntitySet){
		    // ... code to determine which query to call based on entity name
		 EntidadNuevaController ex = null;
		 List<EntidadNueva> foos=getAllFoos();
		    System.out.println("out  on!");
		    EntityCollection entitySet = makeEntityCollection(foos);
		    return entitySet;
		}
}
