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
		
		//1��������������������
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		try {
			//2����������������
			DocumentBuilder builder=factory.newDocumentBuilder();
			//3���õ�xml��document
			Document document=builder.parse(new File("books.xml"));
			
			//����book�ڵ�
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
		// ��ȡ����book��ǩ����
		NodeList list=document.getElementsByTagName("book");
		//��������
		for(int i=0;i<list.getLength();i++) {
			Book book=new Book();
			//��ȡ�����ڵ�
			Node node=list.item(i);
			//�ж������Ƿ���ȷ
			if(node instanceof Element) {
				//����ת��
				Element ele=(Element)node;
				book.setCategory(ele.getAttribute("category"));
				System.out.println("category="+ele.getAttribute("category"));
				book.setLanguage(ele.getAttribute("language"));
				System.out.println("language="+ele.getAttribute("language"));
				
				//��ȡbook�ڵ���ӽڵ�
				NodeList clist=ele.getChildNodes();
				for(int j=0;j<clist.getLength();j++) {
					Node n=clist.item(j);
					if(n instanceof Element) {
						Element ele1=(Element)n;
						if(ele1.getTagName().equals("title")) {
							book.setTitle(ele1.getTextContent());
							//��ȡ��ǩ���ı��ڵ�
							System.out.println(ele1.getTextContent());
						}
						if(ele1.getTagName().equals("author")) {
							book.setAuthor(ele1.getTextContent());
							//��ȡ��ǩ���ı��ڵ�
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
