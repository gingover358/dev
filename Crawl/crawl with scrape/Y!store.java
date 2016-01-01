/* search in Y!store with amazon database. this file doesn't include concepts.
concepts depends on what database is used to. this file can only used with amazonDatabase.
if you wanted to search a profit in rakuten without amazon database, then you should create another file 
to make your wish come true.*/

*java databaseIO
*java internetIO
*java parserIO
*java scrapeIO

public class Y!store{

url="http://auctions.search.yahoo.co.jp/search?auccat=&tab_ex=commerce&ei=utf-8&aq=-1&oq=&sc_i=&fr=auc_top&p="
	option=null;
	DBname=import(amazonDB);
	StoreName="Y!store".

	/*usage: to import, to create, to write, to fetch from amazonDb.*/
	public productsCategory(Dbname,path){
		Str info;
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
	/*all objects*/
	public makerEtc(Dbname,path,option){
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


	/*import layer from amazonDb*/
	public  amazonDbLayerObjects(Dbname){
		Document layer=importLayer(Dbname);
		return layer;
	}

	/*createDb for crawling StoreDb with defined documents*/
	public void createDb(StoreName,Document){
		createDb(name);
		createLayer(name,Document);
	}

/* amazonCategory, productsCategory, maker, productsUrl, ... this is amazonDB's node.
when you wanna use Db, please use above words to access Db layer. And, more precisely 
each nodes are objects. so these hava more informantion other than that urls, 
such as fecth time, price, words etc... */

/* 
	amazonCategory -fetchTime -url -name
	productsCategory -fetchTime -url -name
	makerEtc -fetchtime -url -name -numberOfProducts 
	products -fetchtime -name -modelNumber -releaseDate 
			-listPrice -price usedprice -maker -review -fba
*/
	/*import amazonDb*/
	Str PathToAmazonCategoryLayer;
	Str PathToProductsCategoryLayer;
	Str PathToMakerEtcLayer;
	Str PathToProductsLayer;

	/*interval time(h) to log */
	int Interval=24;

	/*rakuten products 
		-searchwords
		-seller
		-price
		-profit [%]
		-fetchTime
		-url
	*/
	public Obj Products(){
		this.name;
		this.modelNumber;
		this.fetchTime;
		this.AmazonFetchtime;
		this.AmazonPath
		this.url;
		this.mailed;
	}

	public Obj KeywordsProducts(){
		this.keywords;
		this.fetchtime;
		this.url;
		this.mailed
	}

	public Obj seller(){
		this.seller;
		this.profit;
	}

	/*copy all amazonDb path from amazonDb to storeDb/

	/*all path view*/
	public allPath view(Dbname){
		toplayer[i]=topLayer(Dbname);
		second...
		third...

	}

	/*calculate gross profit from AmazonDb*/
	public grossProfit(amazonDb,path,retailerPrice){
		int amazonPrice;
		int grossProfit;
		amazonPrice=products(Dbname,path,price);
		grossProfit=(price/amazonPrice)*100;
		retrun grossProfit;
	}

	public nextPage(html,tag){
		private link;
		if(scrape(html,tag)!=null){
			link=scrape(<div class="nextPage">*</div>);
			return link;
		}
	}

	/*a search with modelNumber*/
	public modelNumberSearch(AmazonDbname,path,StoreDbname){
		modelNumber=products(AmazonDbname,path,modelNumber);
		price=products(AmazonDbname,path,price);
		Str productsUrl;
		Document html;
			if(modelNumber=Null){
				return echo "error!"
			}else{
				for(i=1;i++;i=null){
					for(s=0;s++;s=null){
						productsUrl=url+modelNumber+option;
						html=wget(productsUrl);
						remove(html,<h2><a href="#ITEMURL#" class="rsrSwadItemName">[ＰＲ]#ITEMNAME#</a></h2>);
						html=parsed(html);

						/*scrape&remove*/
						name=scrape(html,<h2>{%}</h2>);
						remove(html,name);
						seller=scrape(html,<div class="pad">{%}</div>{*});
						remove=(html,seller);
						price=scrape(html,<p class="price">{%}</p>);
						remove=scrape(html,price);

						/*create Objects*/
						Obj products=new Products;
						this.searchword=modelNumber;					
						his.seller=seller;
						this.price=price;
						this.profit=grossProfit(AmazonDbname,path,price);
						this.fetchtime=system.currentTime
						this.AmazonFetchtime=products(AmazonDbname,path,fetchtime)

						/*condition to write or not to Database*/
							if(include(name,modelNumber)=true){
								writeNode(StoreDbname,makerEtc,products);
								}else if(include(name,modelNumber)=false){
									return void;
									};
					}
				nextpage(html);
				}
			}
	}

	/*a search with name*/
	public nameSearch(AmazonDbname,Path,StoreDbname){
		Str name;
		Str productsUrl;
		Document html;
		int amazonPrice
		Str seller;
		Str price;
		Str title;
		Str point;
		name=products(StoreDbname,path,name);
		amazonPrice=products(StoreDbname,path,price);
		if(name=null){
			echo "error!"
		}else{
			productsUrl=url+name+option;
			html=wget(productUrl);
			Obj seller= new seller;
			while(exist(html,<tag>){
				title=scrape(tag);
				remove(html,tag);
				seller=(html,tag);
				price=scrape(tag);
				remove(html,price);
				/*point=scrape(tag);
				price=price-point;*/
				seller.title=title;
				seller.seller=seller;
				seller.price=price;
				writeDb(StoreDb,path,seller,seller);
				writepathDb(StoreDb,path,fetchtime);
			}
		}
	}

	/*create keywords from products -name*/
	public keywordsSearch(AmazonDbname,path,Dbname){
		/*write algorythm*/
	}


	/*copy amazonDb path to StoreDb*/
	public createPath(Dbname,StoreDbname){
		copyAllpath(Dbname,StoreDbname);
	}

	/*selected search
		-Dbname amazonDb
		-StoreDbname rakutenDb
		-path specific category such as makerEtc,productsCategory...
	*/
	public selectedSearch(AmazonDbname,StoreDbname){
		path=pleaseWrite();
		products[i];
		Str productsPath[i];
		while(products[0]!=products){
			for(i=0;i++;i=Null){
				products[i]=returnObjects(StoreDbname,path,under);
			}
		}
		while(products[i]=Null){
			productsPath[i]=products[i].path
			modelNumberSerach(AmazonDbname,productspath[i],StoreDbname)
		}
		time=system.currentTime;
		writeDb(StoreDbname,path,fetchTime);
	}

	/*write time to analyze whether crawled or not with the comparing amazonDb, storeDb*/
	public writeAmazonFetchTime(AmazonDbname,path,StoreDbname){

	}

	/*pick up AmazonDb refresh data and new data detected by StoreDb from AmazonDb*/
	public newNode(AmazonDbname,StoreDbname){
		Obj AmazonNode[];
		Obj StoreNode[];	
		/*import node from amazonDb top layer*/
		AmazonNode[i]=import(AmazonDbname,top.layer);
		
		/*import node from StoreDb top layer*/
		StoreNode[i]=import(StoreDbname,top.layer);

		for(i=0;i++;i=null){
			for(s=0;s++;s=null){
				if(AmazonNode[s].fetchTime>StoreNode[s].fetchTime){
					searchNode[s].path=AmazonNode[s].path;
				}else{
					return void;
				}	
			}
			if(products?(searchNodes[s]){
				level=i;
				break;
			}else{
				for(s=0;s++;s=null;){
					layer[i][s]=searchNode[s];
				}
			}
		}
	}

	/*add the newest products in the category that alearedy crawled*/
	public addProducts(AmazonDbname,StoreDbname){
		Str layer[][];
		int level;
		newNode(AmazonDbname,StoreDbname);
		for(i=0;level-i;level>=0;){
			switch (layer[i][0].layer()){
				case products:
					for(s=0;s++;s=null;){
						if(exsit(products(AmazonDbname,layer[i][s],modelNumber)))
							modelNumberSearch(AmazonDbname,layer[i][s],StoreDbname);
						else{
							nameSearch(AmazonDbname,layer[i][s],StoreDbname);
						}
					}break;
				case makerEtc:
					for(s=0;s++;s=null){
						makerEtc(StoreDbname,layer[i][s],amazonPath);
					}
				case productsCategory:

				case amazonCategory:
			}
		}

	}

	/*to create log file to continue crawl after accidents.*/
	public void log{
		Document import(log.txt);
		int starttime;
		int interval;
		int logTime;
		interval=Interval;
		startTime=system.currentTime;
		logTime=startTime+interval;
		do{
			if(system.currentTime=logtime){
			write(log.txt);
			startTime=system.currentTime;
			logtime=starttime+interval;
		}while(shotdown);
	}

	public write(txtdocument){
		/* 
			function used in that time;
			last crawled products;
			the variables state;
		*/
	}

	/*opml file expot with mail*/
	public exportProfits(mailAdress,StoreDbname){

	}
}