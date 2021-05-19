package com.export.domain;





import lombok.Data;
import java.util.List;
@Data
public class PageBean<T> {
    //    1、当前页码
    private int pageNum;
    //    2、每页显示条数
    private int pageSize;
    //    3、每页的数据
    private List list;
    //    4、总条数
    private Long total;
    //    5、总页数
    private int pages;
    //   6、上一页
    private int prePage;
    //    7、下一页
    private int nextPage;
    //    8、起始页码
    private int startRow;
    //    9、结束页码
    private int endRow;

//    页面上传的： pageNum  pageSize
//    数据库查询：total list
//    通过计算获取到的： pages prePage  nextPage  startRow  endRow

    public PageBean(Integer pageNum,Integer pageSize,Long total,List list){
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        this.total=total;
        this.list=list;
//        10条数据 每页显示3条  分4页
//        10条数据 每页显示2条  分5页
        this.pages= total%pageSize==0? (int)(total/pageSize) : (int)((total/pageSize) +1);
        if(pageNum==1){
            this.prePage=1;
        }else{
            this.nextPage=pageNum-1;
        }
        if(pageNum==pages){
            this.nextPage=pageNum;
        }else{
            this.nextPage=pageNum+1;
        }
//        start  end
        calStartAndEnd(pages,pageNum);
    }

    private void calStartAndEnd(int pages,int pageNum) {
//        目标：在页面上始终显示5个页码
//        如果总页数是否超过5
        if(pages<=5){
            this.startRow=1;
            this.endRow=pages;
        }else{
            if(pageNum<=3){
//                情况1：当前页码小于等于3
                this.startRow=1;
                this.endRow=5;
            }else if((pages-pageNum)<=2){
//                情况2：总页数-当前页码<=2
                this.startRow=pages-4;
                this.endRow=pages;
            }else{
                //            剩下的就是情况3：以当前页有中心前面两个页码后面两个页码
                this.startRow=pageNum-2;
                this.endRow=pageNum+2;
            }
        }
    }

}
