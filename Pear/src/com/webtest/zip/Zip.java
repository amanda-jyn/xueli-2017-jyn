    package com.webtest.zip;  
      
    import java.io.BufferedInputStream;  
    import java.io.File;  
    import java.io.FileInputStream;  
    import java.io.FileOutputStream;  
    import java.io.InputStream;  
    import java.io.OutputStream;  
    import java.util.zip.CRC32;  
    import java.util.zip.CheckedOutputStream;  
      
    //ʹ��org.apache.tools.zip����Ͳ�����������  
    import org.apache.tools.zip.ZipEntry;  
    import org.apache.tools.zip.ZipOutputStream;
import org.testng.annotations.Test;  
      
    //ʹ��java.util.zipԭ��ZipOutputStream��ZipEntry����������  
      
    //import java.util.zip.ZipOutputStream;  
    //import java.util.zip.ZipEntry;  
        
    public class Zip   
    {  
        static String filePath = "E:/xueli-2017-jyn/Pear/test-output/";//��Ҫѹ�����ļ�������·��  
        static String fileName = "test-output";//��Ҫѹ�����ļ�����  
        static String outPath = "E:/xueli-2017-jyn/Pear/TestResults.zip";//ѹ����ɺ󱣴�ΪTest.zip�ļ�����������  
          
        public void create() throws Exception  
        {  
            OutputStream is = new FileOutputStream(outPath);//����Test.zip�ļ�  
            CheckedOutputStream cos = new CheckedOutputStream(is, new CRC32());//��������,����CRC32�㷨����֤�ļ���һ����  
            ZipOutputStream zos = new ZipOutputStream(cos);//����zip�ļ��������  
            zos.setEncoding("GBK");//���ñ��룬��ֹ��������  
            File file = new File(filePath);//��Ҫѹ�����ļ����ļ��ж���  
            ZipFile(zos,file);//ѹ���ļ��ľ���ʵ�ֺ���  
            zos.close();  
            cos.close();  
            is.close();  
            System.out.println("ѹ�����");  
        }  
          
        //�ݹ飬��ȡ��Ҫѹ�����ļ���������������ļ�,Ȼ�󴴽���ӦĿ¼���ļ�,���ļ�����ѹ��  
        public void ZipFile(ZipOutputStream zos,File file) throws Exception  
        {  
            if(file.isDirectory())  
            {  
                //����ѹ���ļ���Ŀ¼�ṹ  
                zos.putNextEntry(new ZipEntry(file.getPath().substring(file.getPath().indexOf(fileName))+File.separator));  
      
                for(File f : file.listFiles())  
                {  
                    ZipFile(zos,f);  
                }  
            }  
            else  
            {  
                //��ӡ�������ѹ�����ļ�  
                System.out.println("����ѹ���ļ�:"+file.getName());  
                //����ѹ���ļ�  
                zos.putNextEntry(new ZipEntry(file.getPath().substring(file.getPath().indexOf(fileName))));  
                //���ֽڷ�ʽ��ȡԴ�ļ�  
                InputStream is = new FileInputStream(file.getPath());  
                //����һ��������  
                BufferedInputStream bis = new BufferedInputStream(is);  
                //�ֽ�����,ÿ�ζ�ȡ1024���ֽ�  
                byte [] b = new byte[1024];  
                //ѭ����ȡ���߶���д  
                while(bis.read(b)!=-1)  
                {  
                    zos.write(b);//д��ѹ���ļ�  
                }  
                //�ر���  
                bis.close();  
                is.close();  
            }  
        }  
        @Test
        public void zip() throws Exception{
        	Zip file=new Zip();
        	file.create();
        	file.ZipFile(null, null);
        }
        
    }  