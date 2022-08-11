package ex03_reader;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {
	
	public static void main(String[] args) {
		
		try {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		File file = new File("C:\\storage", "product.xml");
		Document document = builder.parse(file);	// product.xml을 파싱(분석)한 document 객체
		
		// 최상위 요소(root)
		Element root = document.getDocumentElement();
		System.out.println("최상위 요소 : " + root.getNodeName());
		
		// 최상위 요소의 자식 노드들
		NodeList nodeList = root.getChildNodes();
		for(int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);	// 줄바꿈(#text)과 <product> 태그로 구성
			if(node.getNodeType() == Node.ELEMENT_NODE) {	// 노드가 Element인가? _ 줄바꿈(#text) 제외되고, <product> 태그만 남는다.
				NodeList nodeList2 = node.getChildNodes();	// <product> 태그의 자식노드(<number>, <name>, <price> 태그)
				for(int j = 0; j < nodeList2.getLength(); j++) {
					Node node2 = nodeList2.item(j);
					if(node2.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println(node2.getNodeName() + " : " + node2.getTextContent());
					}
				}
			}
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
