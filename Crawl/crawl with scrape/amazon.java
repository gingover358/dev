/* http:amazon.co.jp crawler which uses cycle concepts. there is a possibleity , add shops, abstract logics in this files, extended function with time base crawling dicision. this is beta, only provides cycle concept of amazon crawling.*/

*java internet libraly
*java html parser 
*java database IO

public class amazon{

/* 
	/*layer and its node of amazon Db.
	amazonCategory -fetchTime -url -name
	productsCategory -fetchTime -url -name
	makerEtc -fetchtime -url -name -numberOfProducts 
	products -fetchtime -name -modelNumber -releaseDate -price -maker -review -fba
*/	

	/*Objects wirte to or read from amazonDb*/
	public Obj amazonObjects{
		this.amazonCategory.importLayer(amazon.category)
		this.productsCategory;
		this.makerEtc;
		this.products;
	}
	/*import specific objects from AmazonDB*/
	public Obj amazonCategory{
		this.fetchTime;
		this.url;
		this.name;
	}

	/*usage: to import, to create, to write, to fetch.*/
	public Obj productsCategory{
		this.fetchTime;
		this.url;
		this.name
	}
	/*all objects*/
	public Obj makerEtc{
		this.fetchTime;
		this.url;
		this.name;
		this.numberOfProducts;
	}

	public Obj products{
		this.fetchTime;
		this.name;
		this.modelNumber;
		this.releaseDate;
		this.listPrice;
		this.price;
		this.usedPrice;
		this.maker;
		this.review;
		this.fba;
	}

	/*return path with array structure*/
	public importPath(Dbname,Layer){
		Str path[]=import(Dbname,Layer);
	}

	/*to find the same word in dom.*/
	public match(domObjects,tag){
		if(found(domObjects,tag)){
			return true;
		}else{
			return false;
		}
	}

	/*scrape from Dom with regex.*/
	public scrape(Dom,tag){
		if(match(Dom,tag)){
			Str info[]=serach(Dom,tag);
			return info;
		}else{
			return "scrape error!";
		}
	}

	public Dom(html){
		dom=parse(html);
		return dom;
	}

	/*crawling with no concept*/
	public crawl(url,tag,Dblayer){
		Dom html=require(url).parse;
		Str info=scrape(html,tag)
		write(Dblayer,info);
	}
	/*succesive crawling*/
	public class succesive extends crawl{
		for(i=0;i++;i=null){
			urls[i]=products.url
		}
	}

	/*adding new date from amazon category page*/
	public scrapeAmazonCategory(){
		url="http://www.amazon.co.jp/gp/site-directory/ref=nav_shopall_btn";
		html=wget("http://www.amazon.co.jp/gp/site-directory/ref=nav_shopall_btn");
		Dom parsed;
		parsed=parse(html);
		Obj amazonCategory[] = new amazonCategory;
			for(i=1; i++; i=null){
				amazonCategory[i]=regexScraping(<div class="popover-grouping">*<h2>{%1}</h2><li>*{%2}</li>);
			}
		All amazonCategory[i].fetchtime=system.curentTime;
		for(i=0;i++;i=null){
		writeDb(amazonCategory[i],fetchtime);
		}
	}	

	/*adding new date from products category()*/間違い
	public scrapeProductsCategory(Dbname,amazonCategory[i]){
		Str urls[];
		Str productsCategory[];
		for(i=0;i++;i=null){
			url=amazonCategory[i].url;
			html=wget(url);
			parsed=parsed(url);
			Obj productsCategory= new productsCategory[i];
			productsCategory[i].fetchtime=system.curentTime;
			productsCategory[i].url=regexScrape(parsed,<li class="shoppingEngineExpand">*<a href={%1}*>)
			remove(parsed,productsCategory[i].url);
			productsCategory[i].name=regexScrape(parsed,productsCategory[i].url*<span class="refinementLink">{%2}</span></a></li>);
			remove(parsed,productsCategory[i].name);
			underWriteDb(Dbname,amazonCategory[i].path,productsCategory[i]);	
		}
	}
	
	/*adding makerEtc to database to decreace links to search*/
	public scrapeMakerEtc(Dbname,productsCategory[i]){
		Str urls[];
		Str makerEtc[];
		Document tree;
		for(i=0;i++;i=null){
			url=productsCategory[i].url;
			html=wget(url);
			parsed=parsed(url);
			tree=pickDomTree(<span class="refinementLink ">,3)
			for(s=0;s++;s=null){
				makerEtc[s].fetchtime=system.curentTime;
				makerEtc[s].url=regexscrape(tree,<href=*>)
				makerEtc[s].name=scrape(tree,<span class="refinementLink ">*</span>);
				mekerEtc[s].numberOfProducts=(tree,)
				tree=convertDom(tree);
				underWriteDb(Dbname,productsCategory[i].path,makerEtc[i]);
				remove(html,tree);
			}
		}

	}

	/*adding new url sort option defined by Amazon*/
	public changeSort(option){
		Obj makerEtc[]=new makerEtc;
		makerEtc[0]=import(amazonDb,makerEtc);
		makerEtc.url+=option;
		Str path;
			for(i=0;i++;i=null;){
				path=nextpath(makerEtc[i].path);
				makerEtc[i+1]=import(path);
				makerEtc.url+=path;
			}
	}

	/*adding new date from products pages(*/
	public scrapeProducts(Dbname,makerEtc[]){
		Str url;
		Obj products[]=new products;
		Document html;
		Document parsed;
		Document tree;
			for(i=0;i++;i=null){
			url=makerEtc[i].url;
			html=wget(url);
			parsed=parsed(url);
			tree=pickDomTree(<span class="refinementLink ">,3)
			for(s=0;s++;s=null){
				productsUrl=scrape(page,linkTag);
				remove(parsed,productsUrl);
				productsHtml=wget(productsUrl);
				productsParsed=parse(productsHtml);
				
			}
	}
	/*listing objects of selected layer*/
	public allView(Dbname,Layer){
		Obj amazonCategory[0]= new amazonCategory;
		amazonCategory[0]=import(Dbname,Layer);
		printf(amazonCategory[0].name);
		for(i=0;i++;i=null){
			Obj amazonCategory[i+1]=new amazonCategory; 
			amazonCategory[i+1]=import(Dbname,Layer);
			printf(amazonCategory[i+1]);
		}
	}
}
