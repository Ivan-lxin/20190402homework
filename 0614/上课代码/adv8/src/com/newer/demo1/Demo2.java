package com.newer.demo1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1、创建解析器工厂对象
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		try {
			//2、创建解析器对象
			DocumentBuilder builder=factory.newDocumentBuilder();
			//3、得到xml的document
			Document document=builder.parse(new File("books.xml"));
			
			//遍历book节点
			List<Book> list=getAllBook(document);
			
			list.forEach(book->System.out.println(book));
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private static List<Book> getAllBook(Document document) {
		
		List<Book> books=new ArrayList<>();
		// 获取所有book标签集合
		NodeList list=document.getElementsByTagName("book");
		//遍历集合
		for(int i=0;i<list.getLength();i++) {
			Book book=new Book();
			//获取单个节点
			Node node=list.item(i);
			//判断类型是否正确
			if(node instanceof Element) {
				//向下转型
				Element ele=(Element)node;
				book.setCategory(ele.getAttribute("category"));
				System.out.println("category="+ele.getAttribute("category"));
				book.setLanguage(ele.getAttribute("language"));
				System.out.println("language="+ele.getAttribute("language"));
				
				//获取book节点的子节点
				NodeList clist=ele.getChildNodes();
				for(int j=0;j<clist.getLength();j++) {
					Node n=clist.item(j);
					if(n instanceof Element) {
						Element ele1=(Element)n;
						if(ele1.getTagName().equals("title")) {
							book.setTitle(ele1.getTextContent());
							//获取标签的文本节点
							System.out.println(ele1.getTextContent());
						}
						if(ele1.getTagName().equals("author")) {
							book.setAuthor(ele1.getTextContent());
							//获取标签的文本节点
							System.out.println(ele1.getTextContent());
						}
					}
				}
				System.out.println("=====================");
				books.add(book);
			}
			
		}
		return books;
	}

}
