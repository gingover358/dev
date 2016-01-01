public class StoreDB{

/*common parameter for all*/
Str DBname;

/*define auction data DB*/
	public class category{
		Str title;
		Str url;
		Str fetchTime;
		Str field[];
	}

	public Objects amazonCategory{
		/*to scrape*/
		
		this.url;
		/*to crawl with products advertising api*/
		this.nodeId;
		/*to crawl with mws api*/
		this.mwsId;
		/*common data*/
		this.fetchTime;
		Str field[];
	}

	public Objects productsCategory{
		/*to scrape*/
		this.name;
		this.url;
		/*to crawl with products advertising api*/
		this.nodeId;
		/*to crawl with mws api*/
		this.mwsId;
		/*common data*/
		this.fetchTime;
		this.numberOfoption
		Str field[]
	}

	/*such as maker artist ...*/
	public Objects option{
		/*to scrape*/
		this.name;
		this.url;
		/*to crawl with products advertising api*/
		this.nodeId;
		/*to crawl with mws api*/
		this.mwsId;
		/*common data*/
		this.fetchTime;
		this.numberOfproducts;
		Str field[];
	}

	public Objects products{
		/*to scrape*/
		this.url;
		/*to crawl with products advertising api*/
		this.nodeId;
		/*to crawl with mws api*/
		this.mwsId;
		/*common data*/
		this.name;
		this.modelNumber;
		this.releaseDate;
		this.maker;
		this.price;
		/*optionary data*/
		this.usedPrice;
		this.review;
		this.fba;
		Str field[];
	}

/*read and write function*/
	/*select objects*/
	public objectSelector(DBname,path,objectType){
		switch(objectsType){
			case category:
			category(DBname,path,option);
			break;
			case amazonCategory:
			amazonCategory(Dbname,path,option);
			break;
			case productsCategory:
			productsCategory(Dbname,path,option);
			break;
			case option:
			option(Dbname,path,option);
			break;
			case products:
			products(Dbname,path,option);
			break;
		}
	}

	public category(DBname,path,option){
	    Str this.title;
		Str this.url;
		Str this.fetchTime;
		Str field[];
	}

	public amazonCategory(Dbname,path,option){
		Str info;
		switch(option){
			case "fetchTime"
				info=access(DBname,path,fetchTime);
				return info;
				break;
			case "name"
				info=access(DBname,path,name);
				return info;
				break;
			case "url"
				info=access(DBname,path,name);
				return info;
				break;
			case "nodeId"
				info=access(DBname,path,name);
				return info;
				break;
			case "mwsId";
				info=access(DBname,path,name);
				return info;
				break;
			case"field[]"
				info=access(DBname,path,field)
				return info;
				break;
		}
		Str this.nodeId;
		Str this.mwsId;
		
		Str field[];
	}

	/*define read function*/
	public productsCategory(Dbname,path,option){
		switch (option){
			case "fetchTime"
				info=access(Dbname,path,fetchTime);
				return info;
				break;
			case "url"
				info=access(Dbname,path,url);
				return info;
				break;
			case "name"
				info=access(Dbname,path,name);
				break;
				return info;
		}
	}

	public option(DBname,path,option){
		Str info;
		switch (option){
			case "fetchTime":
				info=access(DBname,path,fetchTime);
				return info;
				break
			case "url":
				info=access(DBname,path,url);
				return info;
				break;
			case "name":
				info=access(DBname,path,name);
				break;
				return info;
			case "numberOfproducts":
				info=access(DBname,path,numberOfproducts);
				return info;
				break;
		}
	}

	public products(DBname,path,option){
		Str info;
		switch (option){
			case "fetchTime"
				info=access(DBname,path,fetchTime);
				return info;
				break;
			case "url":
				info=access(DBname,path,url);
				return info;
				break;
			case "name"
				info=access(DBname,path,name);
				break;
				return info;
			case "modelNumber"
				info=access(DBname,path,modelNumber);
				break;
				return info;
			case "releaseDate"
				info=access(DBname,path,releaseDate);
				break;
				return info;
			case "price"
				info=access(DBname,path,price);
				break;
				return info;
			case "usedPrice"
				info=access(DBname,path,usedPrice);
				break;
				return info;
			case "maker"
				info=access(DBname,path,maker);
				break;
				return info;
			case "review"
				info=access(DBname,path,review);
				break;
				return info;
			case "fba"
				info=access(DBname,path,fba);
				break;
				return info;
		}

	}


	/*define path format*/
	public class path(path)
		objectSelector(DBname,path,objectType);


}
