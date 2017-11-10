package com.example.demo.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController()
@RequestMapping("/api")
public class TestService {

	@RequestMapping(value = "/test1", produces = "application/json")
	public String test() {
		return "{\"value\": \"ok\"}";
	}
	
	@RequestMapping(value = "/current-user", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public User currentUserName(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return user;
    }
	@RequestMapping(value = "/test", produces = "application/xml")
	public String test2() {
		return "<service xmlns=\"http://www.w3.org/2007/app\" xmlns:atom=\"http://www.w3.org/2005/Atom\" xml:base=\"http://services.odata.org/V3/(S(p5nseo0mmpccjs4wb0w3bgx2))/OData/OData.svc/\">\n" + 
				"<workspace>\n" + 
				"<atom:title>Default</atom:title>\n" + 
				"<collection href=\"Products\">\n" + 
				"<atom:title>Products</atom:title>\n" + 
				"</collection>\n" + 
				"<collection href=\"ProductDetails\">\n" + 
				"<atom:title>ProductDetails</atom:title>\n" + 
				"</collection>\n" + 
				"<collection href=\"Categories\">\n" + 
				"<atom:title>Categories</atom:title>\n" + 
				"</collection>\n" + 
				"<collection href=\"Suppliers\">\n" + 
				"<atom:title>Suppliers</atom:title>\n" + 
				"</collection>\n" + 
				"<collection href=\"Persons\">\n" + 
				"<atom:title>Persons</atom:title>\n" + 
				"</collection>\n" + 
				"<collection href=\"PersonDetails\">\n" + 
				"<atom:title>PersonDetails</atom:title>\n" + 
				"</collection>\n" + 
				"<collection href=\"Advertisements\">\n" + 
				"<atom:title>Advertisements</atom:title>\n" + 
				"</collection>\n" + 
				"</workspace>\n" + 
				"</service>";
	}
	@RequestMapping(value = "/test/$metadata", produces = "application/xml")
	public String test3() {
		return "<edmx:Edmx xmlns:edmx=\"http://schemas.microsoft.com/ado/2007/06/edmx\" Version=\"1.0\">\n" + 
				"<edmx:DataServices xmlns:m=\"http://schemas.microsoft.com/ado/2007/08/dataservices/metadata\" m:DataServiceVersion=\"3.0\" m:MaxDataServiceVersion=\"3.0\">\n" + 
				"<Schema xmlns=\"http://schemas.microsoft.com/ado/2009/11/edm\" Namespace=\"ODataDemo\">\n" + 
				"<EntityType Name=\"Product\">\n" + 
				"<Key>\n" + 
				"<PropertyRef Name=\"ID\"/>\n" + 
				"</Key>\n" + 
				"<Property Name=\"ID\" Type=\"Edm.Int32\" Nullable=\"false\"/>\n" + 
				"<Property Name=\"Name\" Type=\"Edm.String\" m:FC_TargetPath=\"SyndicationTitle\" m:FC_ContentKind=\"text\" m:FC_KeepInContent=\"false\"/>\n" + 
				"<Property Name=\"Description\" Type=\"Edm.String\" m:FC_TargetPath=\"SyndicationSummary\" m:FC_ContentKind=\"text\" m:FC_KeepInContent=\"false\"/>\n" + 
				"<Property Name=\"ReleaseDate\" Type=\"Edm.DateTime\" Nullable=\"false\"/>\n" + 
				"<Property Name=\"DiscontinuedDate\" Type=\"Edm.DateTime\"/>\n" + 
				"<Property Name=\"Rating\" Type=\"Edm.Int16\" Nullable=\"false\"/>\n" + 
				"<Property Name=\"Price\" Type=\"Edm.Double\" Nullable=\"false\"/>\n" + 
				"<NavigationProperty Name=\"Categories\" Relationship=\"ODataDemo.Product_Categories_Category_Products\" ToRole=\"Category_Products\" FromRole=\"Product_Categories\"/>\n" + 
				"<NavigationProperty Name=\"Supplier\" Relationship=\"ODataDemo.Product_Supplier_Supplier_Products\" ToRole=\"Supplier_Products\" FromRole=\"Product_Supplier\"/>\n" + 
				"<NavigationProperty Name=\"ProductDetail\" Relationship=\"ODataDemo.Product_ProductDetail_ProductDetail_Product\" ToRole=\"ProductDetail_Product\" FromRole=\"Product_ProductDetail\"/>\n" + 
				"</EntityType>\n" + 
				"<EntityType Name=\"FeaturedProduct\" BaseType=\"ODataDemo.Product\">\n" + 
				"<NavigationProperty Name=\"Advertisement\" Relationship=\"ODataDemo.FeaturedProduct_Advertisement_Advertisement_FeaturedProduct\" ToRole=\"Advertisement_FeaturedProduct\" FromRole=\"FeaturedProduct_Advertisement\"/>\n" + 
				"</EntityType>\n" + 
				"<EntityType Name=\"ProductDetail\">\n" + 
				"<Key>\n" + 
				"<PropertyRef Name=\"ProductID\"/>\n" + 
				"</Key>\n" + 
				"<Property Name=\"ProductID\" Type=\"Edm.Int32\" Nullable=\"false\"/>\n" + 
				"<Property Name=\"Details\" Type=\"Edm.String\"/>\n" + 
				"<NavigationProperty Name=\"Product\" Relationship=\"ODataDemo.Product_ProductDetail_ProductDetail_Product\" ToRole=\"Product_ProductDetail\" FromRole=\"ProductDetail_Product\"/>\n" + 
				"</EntityType>\n" + 
				"<EntityType Name=\"Category\" OpenType=\"true\">\n" + 
				"<Key>\n" + 
				"<PropertyRef Name=\"ID\"/>\n" + 
				"</Key>\n" + 
				"<Property Name=\"ID\" Type=\"Edm.Int32\" Nullable=\"false\"/>\n" + 
				"<Property Name=\"Name\" Type=\"Edm.String\" m:FC_TargetPath=\"SyndicationTitle\" m:FC_ContentKind=\"text\" m:FC_KeepInContent=\"true\"/>\n" + 
				"<NavigationProperty Name=\"Products\" Relationship=\"ODataDemo.Product_Categories_Category_Products\" ToRole=\"Product_Categories\" FromRole=\"Category_Products\"/>\n" + 
				"</EntityType>\n" + 
				"<EntityType Name=\"Supplier\">\n" + 
				"<Key>\n" + 
				"<PropertyRef Name=\"ID\"/>\n" + 
				"</Key>\n" + 
				"<Property Name=\"ID\" Type=\"Edm.Int32\" Nullable=\"false\"/>\n" + 
				"<Property Name=\"Name\" Type=\"Edm.String\" m:FC_TargetPath=\"SyndicationTitle\" m:FC_ContentKind=\"text\" m:FC_KeepInContent=\"true\"/>\n" + 
				"<Property Name=\"Address\" Type=\"ODataDemo.Address\"/>\n" + 
				"<Property Name=\"Location\" Type=\"Edm.GeographyPoint\" SRID=\"Variable\"/>\n" + 
				"<Property Name=\"Concurrency\" Type=\"Edm.Int32\" ConcurrencyMode=\"Fixed\" Nullable=\"false\"/>\n" + 
				"<NavigationProperty Name=\"Products\" Relationship=\"ODataDemo.Product_Supplier_Supplier_Products\" ToRole=\"Product_Supplier\" FromRole=\"Supplier_Products\"/>\n" + 
				"</EntityType>\n" + 
				"<ComplexType Name=\"Address\">\n" + 
				"<Property Name=\"Street\" Type=\"Edm.String\"/>\n" + 
				"<Property Name=\"City\" Type=\"Edm.String\"/>\n" + 
				"<Property Name=\"State\" Type=\"Edm.String\"/>\n" + 
				"<Property Name=\"ZipCode\" Type=\"Edm.String\"/>\n" + 
				"<Property Name=\"Country\" Type=\"Edm.String\"/>\n" + 
				"</ComplexType>\n" + 
				"<EntityType Name=\"Person\">\n" + 
				"<Key>\n" + 
				"<PropertyRef Name=\"ID\"/>\n" + 
				"</Key>\n" + 
				"<Property Name=\"ID\" Type=\"Edm.Int32\" Nullable=\"false\"/>\n" + 
				"<Property Name=\"Name\" Type=\"Edm.String\"/>\n" + 
				"<NavigationProperty Name=\"PersonDetail\" Relationship=\"ODataDemo.Person_PersonDetail_PersonDetail_Person\" ToRole=\"PersonDetail_Person\" FromRole=\"Person_PersonDetail\"/>\n" + 
				"</EntityType>\n" + 
				"<EntityType Name=\"Customer\" BaseType=\"ODataDemo.Person\">\n" + 
				"<Property Name=\"TotalExpense\" Type=\"Edm.Decimal\" Nullable=\"false\"/>\n" + 
				"</EntityType>\n" + 
				"<EntityType Name=\"Employee\" BaseType=\"ODataDemo.Person\">\n" + 
				"<Property Name=\"EmployeeID\" Type=\"Edm.Int64\" Nullable=\"false\"/>\n" + 
				"<Property Name=\"HireDate\" Type=\"Edm.DateTime\" Nullable=\"false\"/>\n" + 
				"<Property Name=\"Salary\" Type=\"Edm.Single\" Nullable=\"false\"/>\n" + 
				"</EntityType>\n" + 
				"<EntityType Name=\"PersonDetail\">\n" + 
				"<Key>\n" + 
				"<PropertyRef Name=\"PersonID\"/>\n" + 
				"</Key>\n" + 
				"<Property Name=\"PersonID\" Type=\"Edm.Int32\" Nullable=\"false\"/>\n" + 
				"<Property Name=\"Age\" Type=\"Edm.Byte\" Nullable=\"false\"/>\n" + 
				"<Property Name=\"Gender\" Type=\"Edm.Boolean\" Nullable=\"false\"/>\n" + 
				"<Property Name=\"Phone\" Type=\"Edm.String\"/>\n" + 
				"<Property Name=\"Address\" Type=\"ODataDemo.Address\"/>\n" + 
				"<Property Name=\"Photo\" Type=\"Edm.Stream\" Nullable=\"false\"/>\n" + 
				"<NavigationProperty Name=\"Person\" Relationship=\"ODataDemo.Person_PersonDetail_PersonDetail_Person\" ToRole=\"Person_PersonDetail\" FromRole=\"PersonDetail_Person\"/>\n" + 
				"</EntityType>\n" + 
				"<EntityType Name=\"Advertisement\" m:HasStream=\"true\">\n" + 
				"<Key>\n" + 
				"<PropertyRef Name=\"ID\"/>\n" + 
				"</Key>\n" + 
				"<Property Name=\"ID\" Type=\"Edm.Guid\" Nullable=\"false\"/>\n" + 
				"<Property Name=\"Name\" Type=\"Edm.String\"/>\n" + 
				"<Property Name=\"AirDate\" Type=\"Edm.DateTime\" Nullable=\"false\"/>\n" + 
				"<NavigationProperty Name=\"FeaturedProduct\" Relationship=\"ODataDemo.FeaturedProduct_Advertisement_Advertisement_FeaturedProduct\" ToRole=\"FeaturedProduct_Advertisement\" FromRole=\"Advertisement_FeaturedProduct\"/>\n" + 
				"</EntityType>\n" + 
				"<Association Name=\"Product_Categories_Category_Products\">\n" + 
				"<End Type=\"ODataDemo.Category\" Role=\"Category_Products\" Multiplicity=\"*\"/>\n" + 
				"<End Type=\"ODataDemo.Product\" Role=\"Product_Categories\" Multiplicity=\"*\"/>\n" + 
				"</Association>\n" + 
				"<Association Name=\"Product_Supplier_Supplier_Products\">\n" + 
				"<End Type=\"ODataDemo.Supplier\" Role=\"Supplier_Products\" Multiplicity=\"0..1\"/>\n" + 
				"<End Type=\"ODataDemo.Product\" Role=\"Product_Supplier\" Multiplicity=\"*\"/>\n" + 
				"</Association>\n" + 
				"<Association Name=\"Product_ProductDetail_ProductDetail_Product\">\n" + 
				"<End Type=\"ODataDemo.ProductDetail\" Role=\"ProductDetail_Product\" Multiplicity=\"0..1\"/>\n" + 
				"<End Type=\"ODataDemo.Product\" Role=\"Product_ProductDetail\" Multiplicity=\"0..1\"/>\n" + 
				"</Association>\n" + 
				"<Association Name=\"FeaturedProduct_Advertisement_Advertisement_FeaturedProduct\">\n" + 
				"<End Type=\"ODataDemo.Advertisement\" Role=\"Advertisement_FeaturedProduct\" Multiplicity=\"0..1\"/>\n" + 
				"<End Type=\"ODataDemo.FeaturedProduct\" Role=\"FeaturedProduct_Advertisement\" Multiplicity=\"0..1\"/>\n" + 
				"</Association>\n" + 
				"<Association Name=\"Person_PersonDetail_PersonDetail_Person\">\n" + 
				"<End Type=\"ODataDemo.PersonDetail\" Role=\"PersonDetail_Person\" Multiplicity=\"0..1\"/>\n" + 
				"<End Type=\"ODataDemo.Person\" Role=\"Person_PersonDetail\" Multiplicity=\"0..1\"/>\n" + 
				"</Association>\n" + 
				"<EntityContainer Name=\"DemoService\" m:IsDefaultEntityContainer=\"true\">\n" + 
				"<EntitySet Name=\"Products\" EntityType=\"ODataDemo.Product\"/>\n" + 
				"<EntitySet Name=\"ProductDetails\" EntityType=\"ODataDemo.ProductDetail\"/>\n" + 
				"<EntitySet Name=\"Categories\" EntityType=\"ODataDemo.Category\"/>\n" + 
				"<EntitySet Name=\"Suppliers\" EntityType=\"ODataDemo.Supplier\"/>\n" + 
				"<EntitySet Name=\"Persons\" EntityType=\"ODataDemo.Person\"/>\n" + 
				"<EntitySet Name=\"PersonDetails\" EntityType=\"ODataDemo.PersonDetail\"/>\n" + 
				"<EntitySet Name=\"Advertisements\" EntityType=\"ODataDemo.Advertisement\"/>\n" + 
				"<FunctionImport Name=\"GetProductsByRating\" ReturnType=\"Collection(ODataDemo.Product)\" EntitySet=\"Products\" m:HttpMethod=\"GET\">\n" + 
				"<Parameter Name=\"rating\" Type=\"Edm.Int16\" Nullable=\"false\"/>\n" + 
				"</FunctionImport>\n" + 
				"<FunctionImport Name=\"Discount\" ReturnType=\"Edm.Double\" IsBindable=\"true\" m:IsAlwaysBindable=\"true\">\n" + 
				"<Parameter Name=\"product\" Type=\"ODataDemo.Product\"/>\n" + 
				"<Parameter Name=\"discountPercentage\" Type=\"Edm.Int32\" Nullable=\"false\"/>\n" + 
				"</FunctionImport>\n" + 
				"<FunctionImport Name=\"IncreaseSalaries\">\n" + 
				"<Parameter Name=\"percentage\" Type=\"Edm.Int32\" Nullable=\"false\"/>\n" + 
				"</FunctionImport>\n" + 
				"<AssociationSet Name=\"Products_Advertisement_Advertisements\" Association=\"ODataDemo.FeaturedProduct_Advertisement_Advertisement_FeaturedProduct\">\n" + 
				"<End Role=\"FeaturedProduct_Advertisement\" EntitySet=\"Products\"/>\n" + 
				"<End Role=\"Advertisement_FeaturedProduct\" EntitySet=\"Advertisements\"/>\n" + 
				"</AssociationSet>\n" + 
				"<AssociationSet Name=\"Products_Categories_Categories\" Association=\"ODataDemo.Product_Categories_Category_Products\">\n" + 
				"<End Role=\"Product_Categories\" EntitySet=\"Products\"/>\n" + 
				"<End Role=\"Category_Products\" EntitySet=\"Categories\"/>\n" + 
				"</AssociationSet>\n" + 
				"<AssociationSet Name=\"Products_Supplier_Suppliers\" Association=\"ODataDemo.Product_Supplier_Supplier_Products\">\n" + 
				"<End Role=\"Product_Supplier\" EntitySet=\"Products\"/>\n" + 
				"<End Role=\"Supplier_Products\" EntitySet=\"Suppliers\"/>\n" + 
				"</AssociationSet>\n" + 
				"<AssociationSet Name=\"Products_ProductDetail_ProductDetails\" Association=\"ODataDemo.Product_ProductDetail_ProductDetail_Product\">\n" + 
				"<End Role=\"Product_ProductDetail\" EntitySet=\"Products\"/>\n" + 
				"<End Role=\"ProductDetail_Product\" EntitySet=\"ProductDetails\"/>\n" + 
				"</AssociationSet>\n" + 
				"<AssociationSet Name=\"Persons_PersonDetail_PersonDetails\" Association=\"ODataDemo.Person_PersonDetail_PersonDetail_Person\">\n" + 
				"<End Role=\"Person_PersonDetail\" EntitySet=\"Persons\"/>\n" + 
				"<End Role=\"PersonDetail_Person\" EntitySet=\"PersonDetails\"/>\n" + 
				"</AssociationSet>\n" + 
				"</EntityContainer>\n" + 
				"<Annotations Target=\"ODataDemo.DemoService\">\n" + 
				"<ValueAnnotation Term=\"Org.OData.Display.V1.Description\" String=\"This is a sample OData service with vocabularies\"/>\n" + 
				"</Annotations>\n" + 
				"<Annotations Target=\"ODataDemo.Product\">\n" + 
				"<ValueAnnotation Term=\"Org.OData.Display.V1.Description\" String=\"All Products available in the online store\"/>\n" + 
				"</Annotations>\n" + 
				"<Annotations Target=\"ODataDemo.Product/Name\">\n" + 
				"<ValueAnnotation Term=\"Org.OData.Display.V1.DisplayName\" String=\"Product Name\"/>\n" + 
				"</Annotations>\n" + 
				"<Annotations Target=\"ODataDemo.DemoService/Suppliers\">\n" + 
				"<ValueAnnotation Term=\"Org.OData.Publication.V1.PublisherName\" String=\"Microsoft Corp.\"/>\n" + 
				"<ValueAnnotation Term=\"Org.OData.Publication.V1.PublisherId\" String=\"MSFT\"/>\n" + 
				"<ValueAnnotation Term=\"Org.OData.Publication.V1.Keywords\" String=\"Inventory, Supplier, Advertisers, Sales, Finance\"/>\n" + 
				"<ValueAnnotation Term=\"Org.OData.Publication.V1.AttributionUrl\" String=\"http://www.odata.org/\"/>\n" + 
				"<ValueAnnotation Term=\"Org.OData.Publication.V1.AttributionDescription\" String=\"All rights reserved\"/>\n" + 
				"<ValueAnnotation Term=\"Org.OData.Publication.V1.DocumentationUrl \" String=\"http://www.odata.org/\"/>\n" + 
				"<ValueAnnotation Term=\"Org.OData.Publication.V1.TermsOfUseUrl\" String=\"All rights reserved\"/>\n" + 
				"<ValueAnnotation Term=\"Org.OData.Publication.V1.PrivacyPolicyUrl\" String=\"http://www.odata.org/\"/>\n" + 
				"<ValueAnnotation Term=\"Org.OData.Publication.V1.LastModified\" String=\"4/2/2013\"/>\n" + 
				"<ValueAnnotation Term=\"Org.OData.Publication.V1.ImageUrl \" String=\"http://www.odata.org/\"/>\n" + 
				"</Annotations>\n" + 
				"</Schema>\n" + 
				"</edmx:DataServices>\n" + 
				"</edmx:Edmx>";
	}
}
