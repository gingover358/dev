/* 		Database for amazon crawling. we start define tables, next we define data structure in node models 
	and, layer models. this database has two methods to access specific table.

		First, using node model. This method can be used, when you

			-down :to access children, retrun children paths;
-			-up	:to access parent, return parent path;
	
	besicaly,these commands return children paths or parent path. but this node can have children created by
	same data table. 

		this is really useful function, when you encounter a category which contains too many data to crawl.
	if you want to access low level node directly from higher level then, you can use

			-downNode :to access childrenNode, return children paths; 
			-upNode :to access parentNode, return top parent path in the node;
*/

public class AmazonDB{

	/*specify your Dbinfo*/
	Str DBplace=amazonDb;

	/*------------------
	define data Objects
	-------------------*/
	public Objects category{
		this.title;
		this.url;
		this.fetchTime;
		Str field[];
	}

	public Objects amazonCategory{
		/*to scrape*/
		this.name;
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

	/*----------------------------
	-----define read function-----
	----------------------------*/
	public category(DBname,path){
		switch(option){
			case "title":
			info=access(Dbname,path,fetchTime);
			return info;
			break;
			case "url":
			info=access(Dbname,path,url);
			return info;
			break;
			case "fetchTime":
			info=access(Dbname,path,fetchTime);
			return info;
			break;
			case "field"
			info=access(DBname,path,fetchTime)
		}
		this.title;
		this.url;
		this.fetchTime;
		Str field[];
	}

	public amazonCategory(Dbname,path){
		/*to scrape*/
		this.name;
		this.url;
		/*to crawl with products advertising api*/
		this.nodeId;
		/*to crawl with mws api*/
		this.mwsId;
		/*common data*/
		this.fetchTime;
		Str field[];
	}

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

	public option(Dbname,path,option){
		Str info;
		switch (option){
			case "fetchTime":
				info=access(Dbname,path,fetchTime);
				return info;
				break
			case "url":
				info=access(Dbname,path,url);
				return info;
				break;
			case "name":
				info=access(Dbname,path,name);
				break;
				return info;
			case "numberOfproducts":
				info=access(Dbname,path,numberOfproducts);
				return info;
				break;
		}
	}

	public products(Dbname,path,option){
		Str info;
		switch (option){
			case "fetchTime"
				info=access(Dbname,path,fetchTime);
				return info;
				break;
			case "url":
				info=access(Dbname,path,url);
				return info;
				break;
			case "name"
				info=access(Dbname,path,name);
				break;
				return info;
			case "modelNumber"
				info=access(Dbname,path,modelNumber);
				break;
				return info;
			case "releaseDate"
				info=access(Dbname,path,releaseDate);
				break;
				return info;
			case "price"
				info=access(Dbname,path,price);
				break;
				return info;
			case "usedPrice"
				info=access(Dbname,path,usedPrice);
				break;
				return info;
			case "maker"
				info=access(Dbname,path,maker);
				break;
				return info;
			case "review"
				info=access(Dbname,path,review);
				break;
				return info;
			case "fba"
				info=access(Dbname,path,fba);
				break;
				return info;
		}
	}
	
	public objectSelector(Dbname,path,objectType){
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

	/*define write function*/
	public class writeDB(DBname,path){
		return objectInDB;
	}

	/*define table prameter*/
	public class table{
		this.type;
		this.numberId;
	}

	/*define data structure with node model*/
	public returnPath(DBplace,path,option){
		if(path=!null){
			switch(option){
				case up:
				case down:
				case upNode:
				case downNode:
			}
		}else{
			echo "error!";
		}
	}
	
	public examine(up,path){
		int and;
		and=up&path;
		if(up&path){
			return 2;
		}else{
			if(up=true){
				return up;
			}else{
				return down;
			}
		}
	}

	public returnType(objectsType,option){
		switch(option){
			case down:
				switch(objectsType){
					case category:
						return "amazonCategory";
						break;
					case amazonCategory:
						return "productsCategory";
						break;
					case productsCategory:
						return "option";
						break;
					case option:
						return "products"
						break;
				}
			case up:
				switch(objectsType){
					case amazonCategory:
						return "category";
						break;
					case productsCategory:
						return "amazonCategory";
						break;
					case option:
						return "productsCategory";
						break;
					case products:
						return "option";
						break;
				}
		}
	}

	/*to add path concept*/
	public createDbObject(DBplace,path,objects){
		/*if createde objects is the same type with parentscategory,then,*/
		Str upPath;
		Str downPath;
		Str pathList[]
		int up;
		int down;
		if(exist(path)){
			upPath=returnPath(DBplace,path,up);
			up=sametype(objects,access(Dbname.path);
			downPath=retrunPath(DBplace,path,down);
			down=sametype(objects,access(path,type));
				switch(examin(up,down)){
					case :2

						break;
					case :down
						objectSelector(DBname,downPath,objects.type()).path=path;
						write(DBplace,path,objects);
						break;
					case :up
						pathList[]=returnPath(DBplace,path,down);
						int i=0;
						do{
							pathList[i]
							i++;
						}
						write(DBplace,path,objects);
						break;
				}
			}
		}else{

		}
	}

	/*define data structure with layer model excluded create option,only access function*/
	public define(){
		
	}
}