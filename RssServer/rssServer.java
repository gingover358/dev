/*rss server to crawl products that can not make a profit yet.
this class provide below functions 
	-crawl  :crawl specific products in the store from the storeDb
	-export :export xmlfile or ompl file adapted to rss reader
*/

public class rssServer(){
	/*used for accumulate path list*/
	Str pathList[];
	/*used for identify shop database to pick data*/
	Str DBname;
	/*used for crawling*/
	Str DBrss;
	/*crawl interval*/ 
	int fetchIntervel=21600;
	/*arrayList to fetch*/
	Obj list[i];

	/*create a url list from pathlist txt*/
	public class createList(txtFiles){
		do{
			pathList[i]=scrape(<path>*{%}</path>);
		}while(pathlist[i]!=null);
	}

	/*create feed objects from txt files*/
	public class createFeeds(DBname,pathList[i],DBrss){
		for(i=0; i=pathList.length; i++;){
			list[i]=new feed;
			if(exist(pathList[i],DBrss){
				createPath(pathList[i],DBrss);
			}else{
				writeDB(DBrss,access(DBname,path).fetchTime,);
			}
		while(pathList[i]!=null){
		pathList[0].fetchTime=up(DBrss,pathlist[0].fetchTime);
		}
		createOpml(pathList[]);
	}

	/*delete feeds*/
	public class delete(DBrss,txtFiles){
		Str path;
		int i;
		int i=0;
		do{
			path=scrape(<path>*{%}<path>);
			deleteNodes(DBrss,path)
		}while(path[i]!=null);
	}

	
}