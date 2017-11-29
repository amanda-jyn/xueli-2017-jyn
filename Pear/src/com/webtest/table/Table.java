package com.webtest.table;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table {
	WebElement table;
	
	public Table(WebElement table){
		this.table=table;
	}
	
	public int getRowCount(){
		List<WebElement> rows = this.table.findElements(By.tagName("tr"));
		return rows.size();
	}
	public int getColCount(){
		List<WebElement> rows = this.table.findElements(By.tagName("tr"));
		return rows.get(0).findElements(By.tagName("td")).size();
	}
	
	public WebElement getCell(int rowNO,int colNO){
		List<WebElement> rows=this.table.findElements(By.tagName("tr"));
		WebElement currentRow=rows.get(rowNO-1);
		List<WebElement> cols=currentRow.findElements(By.tagName("td"));
		WebElement currentCell=cols.get(colNO-1);
		return currentCell;
	}
}
