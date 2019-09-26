package JASON的使用;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * 4.2.1什么是XML？
 * 它是可扩展标记语言（Extensible Markup Language，简称XML），是一种标记语言。
 * XML 全称为可扩展的标记语言。主要用于描述数据和用作配置文件。
 * XML 文档在逻辑上主要由一下 5 个部分组成：
 * XML 声明：指明所用 XML 的版本、文档的编码、文档的独立性信息
 * 文档类型声明：指出 XML 文档所用的 DTD
 * 元素：由开始标签、元素内容和结束标签构成
 * 注释：以结束，用于对文档中的内容起一个说明作用
 * 处理指令：通过处理指令来通知其他应用程序来处理非 XML 格式的数据，格式为
 * 　　XML 文档的根元素被称为文档元素，它和在其外部出现的处理指令、注释等作为文档实体的子节点，根元素本身和其内部的子元素也是一棵树。
 *
 *
 * 4.2.3Dom4j与Sax区别
 *  dom4j不适合大文件的解析，因为它是一下子将文件加载到内存中，所以有可能出现内存溢出，sax是基于事件来对xml进行解析的，
 * 所以他可以解析大文件的xml，也正是因为如此，所以dom4j可以对xml进行灵活的增删改查和导航，而sax没有这么强的灵活性，
 * 所以sax经常是用来解析大型xml文件，而要对xml文件进行一些灵活（crud）操作就用dom4j。
 *
 *
 * 注意:
 *  this.getClass().getClassLoader().getResourceAsStream(xmlPath) 获取当前项目路径xmlfsfs
 */
public class xml解析 {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("G:\\IDEATetsWork\\AnnotionAndDesignPatterns\\src\\main\\resources\\Students.xml"));
        // 获取根节点
        Element rootElement = read.getRootElement();
        getNodes(rootElement);

    }

    static public void getNodes(Element rootElement) {
        System.out.println("当前节点名称:" + rootElement.getName());
        // 获取属性ID
        List<Attribute> attributes = rootElement.attributes();
        for (Attribute attribute : attributes) {
            System.out.println("属性:" + attribute.getName() + "---" + attribute.getText());
        }
        if (!rootElement.getTextTrim().equals("")) {
            System.out.println(rootElement.getName() + "--" + rootElement.getText());
        }
        // 使用迭代器遍历
        Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()) {
            Element next = elementIterator.next();
            getNodes(next);
        }
    }
}
