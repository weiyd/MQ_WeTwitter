package com.wetwitter.modules.common.utils;


/**
 * <p>Title: BS综合营业系统-公用模块</p>
 * <p>Description: 字符串处理 帮助类</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: ZTESoft</p>
 *
 * @author 胡海华
 * @version 1.0
 */


import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

/**
 * String 的工具类，在JDK1.4中有更好的方法可以替代，请参考JDK1.4 JavaDoc。
 *
 * @author guojun
 * @version 1.0
 */
public class StringHelper {

    /**
     * 日志器
     */
    private static final Logger _logger = Logger.getLogger(StringHelper.class);

    private static final char QUOTE_ENCODE[] = "&quot;".toCharArray();
    private static final char AMP_ENCODE[] = "&amp;".toCharArray();
    private static final char LT_ENCODE[] = "&lt;".toCharArray();
    private static final char GT_ENCODE[] = "&gt;".toCharArray();

    private StringHelper() {
    }


    /**
     * 用新的字符串替换给定字符串中的老的字符串
     *
     * @param string
     * @param oldString
     * @param newString
     * @return
     */
    public static final String replace(String string,
                                       String oldString,
                                       String newString) {
        if (string == null) {
            return null;
        }
        if (newString == null) {
            return string;
        }
        int i = 0;
        if ((i = string.indexOf(oldString, i)) >= 0) {
            char string2[] = string.toCharArray();
            char newString2[] = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(string2.length);
            buf.append(string2, 0, i).append(newString2);
            i += oLength;
            int j;
            for (j = i; (i = string.indexOf(oldString, i)) > 0; j = i) {
                buf.append(string2, j, i - j).append(newString2);
                i += oLength;
            }

            buf.append(string2, j, string2.length - j);
            return buf.toString();
        } else {
            return string;
        }
    }


    /**
     * 忽略大小写的替换
     *
     * @param line
     * @param oldString
     * @param newString
     * @return
     */
    public static final String replaceIgnoreCase(String line, String oldString,
                                                 String newString) {
        if (line == null) {
            return null;
        }
        String lcLine = line.toLowerCase();
        String lcOldString = oldString.toLowerCase();
        int i = 0;
        if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
            char line2[] = line.toCharArray();
            char newString2[] = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j;
            for (j = i; (i = lcLine.indexOf(lcOldString, i)) > 0; j = i) {
                buf.append(line2, j, i - j).append(newString2);
                i += oLength;
            }

            buf.append(line2, j, line2.length - j);
            return buf.toString();
        } else {
            return line;
        }
    }


    /**
     * 忽略大小写的替换，并且返回替换个个数
     *
     * @param line
     * @param oldString
     * @param newString
     * @param count     替换个数数组 通过new int[0]来调用
     *                  （为什么是数组，因为Java中基本数据类型是按值传递的而对象是按引用传递的）
     * @return
     */
    public static final String replaceIgnoreCase(String line, String oldString,
                                                 String newString, int count[]) {
        if (line == null) {
            return null;
        }
        String lcLine = line.toLowerCase();
        String lcOldString = oldString.toLowerCase();
        int i = 0;
        if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
            int counter = 1;
            char line2[] = line.toCharArray();
            char newString2[] = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j;
            for (j = i; (i = lcLine.indexOf(lcOldString, i)) > 0; j = i) {
                counter++;
                buf.append(line2, j, i - j).append(newString2);
                i += oLength;
            }

            buf.append(line2, j, line2.length - j);
            count[0] = counter;
            return buf.toString();
        } else {
            return line;
        }
    }


    /**
     * 替换字符串，并且返回替换的个数
     *
     * @param line
     * @param oldString
     * @param newString
     * @param count
     * @return
     */
    public static final String replace(String line, String oldString,
                                       String newString, int count[]) {
        if (line == null) {
            return null;
        }
        int i = 0;
        if ((i = line.indexOf(oldString, i)) >= 0) {
            int counter = 1;
            char line2[] = line.toCharArray();
            char newString2[] = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j;
            for (j = i; (i = line.indexOf(oldString, i)) > 0; j = i) {
                counter++;
                buf.append(line2, j, i - j).append(newString2);
                i += oLength;
            }

            buf.append(line2, j, line2.length - j);
            count[0] = counter;
            return buf.toString();
        } else {
            return line;
        }
    }


    /**
     * 剥去字符串中的HTML标签
     *
     * @param in
     * @return
     */
    public static final String stripTags(String in) {
        if (in == null) {
            return null;
        }
        int i = 0;
        int last = 0;
        char input[] = in.toCharArray();
        int len = input.length;
        StringBuffer out = new StringBuffer((int) ((double) len * 1.3D));
        for (; i < len; i++) {
            char ch = input[i];
            if (ch <= '>') {
                if (ch == '<') {
                    if (i + 3 < len && input[i + 1] == 'b' &&
                            input[i + 2] == 'r' && input[i + 3] == '>') {
                        i += 3;
                    } else {
                        if (i > last) {
                            if (last > 0) {
                                out.append(" ");
                            }
                            out.append(input, last, i - last);
                        }
                        last = i + 1;
                    }
                } else if (ch == '>') {
                    last = i + 1;
                }
            }
        }

        if (last == 0) {
            return in;
        }
        if (i > last) {
            out.append(input, last, i - last);
        }
        return out.toString();
    }


    /**
     * 字符串中的HTML标签替换
     *
     * @param in
     * @return
     */
    public static final String escapeHTMLTags(String in) {
        if (in == null) {
            return null;
        }
        int i = 0;
        int last = 0;
        char input[] = in.toCharArray();
        int len = input.length;
        StringBuffer out = new StringBuffer((int) ((double) len * 1.3D));
        for (; i < len; i++) {
            char ch = input[i];
            if (ch <= '>') {
                if (ch == '<') {
                    if (i > last) {
                        out.append(input, last, i - last);
                    }
                    last = i + 1;
                    out.append(LT_ENCODE);
                } else if (ch == '>') {
                    if (i > last) {
                        out.append(input, last, i - last);
                    }
                    last = i + 1;
                    out.append(GT_ENCODE);
                } else if (ch == '"') {
                    if (i > last) {
                        out.append(input, last, i - last);
                    }
                    last = i + 1;
                    out.append(QUOTE_ENCODE);
                }
            }
        }

        if (last == 0) {
            return in;
        }
        if (i > last) {
            out.append(input, last, i - last);
        }
        return out.toString();
    }

    public static final String[] split(String line, String separator) {
        LinkedList list = new LinkedList();
        if (line != null) {
            int start = 0;
            int end = 0;
            int separatorLen = separator.length();
            while ((end = line.indexOf(separator, start)) >= 0) {
                list.add(line.substring(start, end));
                start = end + separatorLen;
            }
            if (start < line.length()) {
                list.add(line.substring(start, line.length()));
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }


    /**
     * 获得字符的字母（限GBK字符集）
     *
     * @param ch          char
     * @param isUpperCase boolean
     * @return char
     */
    private static char getPYIndexChar(char ch, boolean isUpperCase) {

        if (Character.getType(ch) != Character.OTHER_LETTER) {
            return ch;
        }

        int[] aTmp = new int[2];
        String str = new String("" + ch);
        try {
            aTmp = byteToInt(str.getBytes("GBK"));
        } catch (UnsupportedEncodingException e) {
            return ch;
        }

        int nHexCode = (aTmp[0] << 8) + aTmp[1];
        //_logger.info("nHexCode=" + nHexCode);
        if ((nHexCode >= '\uB0A1') && (nHexCode <= '\uB0C4')) {
            ch = 'a';
        } else if ((nHexCode >= '\uB0C5') && (nHexCode <= '\uB2C0')) {
            ch = 'b';
        } else if ((nHexCode >= '\uB2C1') && (nHexCode <= '\uB4ED')) {
            ch = 'c';
        } else if ((nHexCode >= '\uB4EE') && (nHexCode <= '\uB6E9')) {
            ch = 'd';
        } else if ((nHexCode >= '\uB6EA') && (nHexCode <= '\uB7A1')) {
            ch = 'e';
        } else if ((nHexCode >= '\uB7A2') && (nHexCode <= '\uB8C0')) {
            ch = 'f';
        } else if ((nHexCode >= '\uB8C1') && (nHexCode <= '\uB9FD')) {
            ch = 'g';
        } else if ((nHexCode >= '\uB9FE') && (nHexCode <= '\uBBF6')) {
            ch = 'j';
        } else if ((nHexCode >= '\uBBF7') && (nHexCode <= '\uBFA5')) {
            ch = 'i';
        } else if ((nHexCode >= '\uBFA6') && (nHexCode <= '\uC0AB')) {
            ch = 'k';
        } else if ((nHexCode >= '\uBBF7') && (nHexCode <= '\uBFA5')) {
            ch = 'l';
        } else if ((nHexCode >= '\uC0AC') && (nHexCode <= '\uC4C2')) {
            ch = 'm';
        } else if ((nHexCode >= '\uC4C3') && (nHexCode <= '\uC5B5')) {
            ch = 'n';
        } else if ((nHexCode >= '\uC5B6') && (nHexCode <= '\uC5BD')) {
            ch = 'o';
        } else if ((nHexCode >= '\uC5BE') && (nHexCode <= '\uC6D9')) {
            ch = 'p';
        } else if ((nHexCode >= '\uC6DA') && (nHexCode <= '\uC8BA')) {
            ch = 'q';
        } else if ((nHexCode >= '\uC8BB') && (nHexCode <= '\uC8F5')) {
            ch = 'r';
        } else if ((nHexCode >= '\uC8F6') && (nHexCode <= '\uCBF9')) {
            ch = 's';
        } else if ((nHexCode >= '\uCBFA') && (nHexCode <= '\uCDD9')) {
            ch = 't';
        } else if ((nHexCode >= '\uCDDA') && (nHexCode <= '\uCEF3')) {
            ch = 'w';
        } else if ((nHexCode >= '\uCEF4') && (nHexCode <= '\uD188')) {
            ch = 'x';
        } else if ((nHexCode >= '\uD1B9') && (nHexCode <= '\uD4D0')) {
            ch = 'y';
        } else if ((nHexCode >= '\uD4D1') && (nHexCode <= '\uD7F9')) {
            ch = 'z';
        } else if (nHexCode == '\uE667') { //'鎔'
            ch = 'r';
        }

        return (isUpperCase ? Character.toUpperCase(ch) : ch);
    }

    private static int[] byteToInt(byte[] b) {
        int[] buff = new int[b.length];
        for (int i = 0; i < buff.length; i++) {
            buff[i] = b[i] & 0xFF;
        }
        return buff;
    }


    /**
     * 将汉字转换为大写拼音字母
     *
     * @param str         String 汉字字符串
     * @param isUpperCase boolean 是否大写
     * @return String 字母字符串
     */
    protected static String toPy(String str, boolean isUpperCase) {
        int length = str.length();
        StringBuffer sb = new StringBuffer();
        char ch;
        for (int i = 0; i < length; i++) {
            ch = getPYIndexChar(str.charAt(i), isUpperCase);
            sb.append(ch);
        }
        return sb.toString();
    }


    /**
     * 将汉字转换为大写拼音字母
     *
     * @param str String 汉字字符串
     * @return String 字母字符串
     */
    protected static String toPy(String str) {
        return toPy(str, true);
    }


    /**
     * 加密字符串
     * 使用MD5算法（不可逆）
     *
     * @param str 输入字符串，可以是中文
     * @return 加密后的字符串，长度为32
     */
    protected static String encode(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            _logger.info("非法摘要算法");
            return null;
        }
        md.update(str.getBytes());
        return toHex(md.digest());
    }


    /**
     * byte数组转化成16进制String
     *
     * @param buffer byte[] byte数组
     * @return String
     */
    protected static String toHex(byte buffer[]) {
        StringBuffer sb = new StringBuffer();
        String s = null;
        for (int i = 0; i < buffer.length; i++) {
            s = Integer.toHexString((int) buffer[i] & 0xff);
            if (s.length() < 2) {
                sb.append('0');
            }
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * 替换null.
     *
     * @param str String
     * @return String
     */

    public final static String replaceNull(String str) {
        return (str != null) ? str : "";
    }

}
