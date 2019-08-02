package com.example.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.BeanUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TestUtil {
	public static void main(String[] args) {
//		List<String> list=new ArrayList<String>();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add("d");
//		list.add("e");
//		list.add("f");
//		Page<String> page=new Page<>(list,2,2);
		
	    System.out.println(Math.ceil(3*1.0/2));
	}
}	


class Page<T> {
	//当前页
		private Integer pageNum;
		//总记录数
		private Integer total;
		//总页数
		private Integer pages;
		
		//当前页显示多少条记录
		private Integer pageSize;
		
		private List<T> list;
		
		public Page(List<T> list,Integer pageNum,Integer pageSize){
		
			this.pageNum  = pageNum;
			this.pageSize = pageSize;
			this.total = list.size();
			
			//总记录数和每页显示的记录之间是否可以凑成整数（pages）
			boolean full = total % pageSize == 0;
				
			//分页 == 根据pageSize（每页显示的记录数）计算pages
			if(!full){
				//如果凑不成整数
				this.pages = total/pageSize + 1;
			}else{
				//如果凑成整数
				this.pages = total/pageSize;
			}
			
			int fromIndex = 0;
			int toIndex   = 0;
			fromIndex = pageNum*pageSize-pageSize;
			if(pageNum == 0){
				throw new ArithmeticException("第0页无法展示");
			}else if(pageNum>pages){
				//如果查询的页码数大于总的页码数，list设置为[]
				list = new ArrayList<>();
			}else if(pageNum == pages){
				//如果查询的当前页等于总页数，直接索引到total处
				toIndex = total;
			}else{		
				//如果查询的页码数小于总页数，不用担心切割List的时候toIndex索引会越界，直接等
				toIndex   = pageNum*pageSize;			
			}	
			
			if(list.size() == 0){
				this.list = list;
			}else{
				this.list = list.subList(fromIndex, toIndex);
			}
			
		}
		 
	 
		
		public Integer getPageNum() {
			return pageNum;
		}
	 
	 
		public void setPageNum(Integer pageNum) {
			this.pageNum = pageNum;
		}
	 
	 
		public Integer getTotal() {
			return total;
		}
	 
	 
		public void setTotal(Integer total) {
			this.total = total;
		}
	 
	 
		public Integer getPages() {
			return pages;
		}
	 
	 
		public void setPages(Integer pages) {
			this.pages = pages;
		}
	 
	 
		public Integer getPageSize() {
			return pageSize;
		}
	 
	 
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
	 
	 
		public List<T> getList() {
			return list;
		}
	 
	 
		public void setList(List<T> list) {
			this.list = list;
		}



		@Override
		public String toString() {
			return "Page [pageNum=" + pageNum + ", total=" + total + ", pages=" + pages + ", pageSize=" + pageSize
					+ ", list=" + list + "]";
		}
    
}


class Foo {
    private CountDownLatch countDownLatchA;
    private CountDownLatch countDownLatchB;

    public Foo() {
        countDownLatchA = new CountDownLatch(1);
        countDownLatchB = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatchA.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatchA.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatchB.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatchB.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

