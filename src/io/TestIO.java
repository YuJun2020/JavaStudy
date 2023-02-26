package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.zip.*;

public class TestIO {
    public static void main(String[] args) throws IOException {
        zip();
    }

    public static String read1() throws IOException {
        File file = new File("C:\\Users\\Yu Jun\\Documents\\temp\\余君.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        StringBuffer stringBuffer = new StringBuffer();
        String s;
        while( (s = in.readLine()) != null){
            System.out.println(s);
            stringBuffer.append(s);
        }
        in.close();
        return stringBuffer.toString();
    }

    public static void write1() throws IOException {
        File file = new File("C:\\Users\\Yu Jun\\Documents\\temp\\余君.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Yu Jun\\Documents\\temp\\demo.txt")));
        StringBuffer stringBuffer = new StringBuffer();
        String s;
        while( (s = in.readLine()) != null){
            out.println(s);
        }
        in.close();
        out.close();
    }



    public static void read2() throws IOException {
        String str = "dsfsdf";
        StringReader reader = new StringReader("我在学Java");
        int read;
        while((read = reader.read()) != -1){
            System.out.print((char)read);
        }
        reader.close();
    }

    public static void read3() throws IOException {
        String str = "dsfsdf";
        DataInputStream stream = new DataInputStream(new ByteArrayInputStream(str.getBytes()));
        while(stream.available() != 0){
            System.out.print((char)stream.readByte());
        }
    }

    public static void channel() throws IOException {
        FileChannel channel = new RandomAccessFile("D:\\IDEA\\aaa.txt","rw").getChannel();
        channel.write(ByteBuffer.wrap("aaa".getBytes()));
        channel.close();
        channel = new RandomAccessFile("D:\\IDEA\\aaa.txt","rw").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        channel.read(byteBuffer);
        byteBuffer.flip();
        while(byteBuffer.hasRemaining()){
            System.out.println((char)byteBuffer.get());
        }
        channel.close();
    }

    public static void gzip() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Yu Jun\\Documents\\temp\\余君.txt"));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("C:\\Users\\Yu Jun\\Documents\\temp\\test.gz")));
        String s;
        while((s=in.readLine()) != null){
            out.write(s.getBytes(Charset.defaultCharset()));
        }
        in.close();
        out.close();
    }

    public static void zip() throws IOException {
        CheckedOutputStream csum = new CheckedOutputStream(
                new FileOutputStream("d:\\test.zip"), new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        String[] args = new String[]{"d:\\余君.txt","d:\\新文件 5.txt"};
        for(String arg : args){
            BufferedReader reader = new BufferedReader(new FileReader(arg));
            String[] split = arg.split("\\\\");
            zos.putNextEntry(new ZipEntry(split[split.length-1]));
            String s;
            while((s=reader.readLine()) != null){
                out.write(s.getBytes(Charset.defaultCharset()));
            }
            reader.close();
            out.flush();
        }
        out.close();
    }
}
