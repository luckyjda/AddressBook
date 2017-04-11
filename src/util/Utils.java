package util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static final String TAG = "Utils";
    private static final Random RANDOM = new Random();

    /**
     * ����û���
     */
    public static boolean checkName(final String username) {
        String strPattern = "^[A-Za-z0-9_]{3,12}$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(username);
        return m.matches();
    }

    /**
     * �ж������ʽ
     */
    public static boolean checkPassword(final String password) {
        String strPattern = "^[A-Za-z0-9_]{6,16}$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    /**
     * ����ǰϵͳʱ���ʽ��Ϊ�ض��ĸ�ʽ����ʽ�ο� SimpleDateFormat ��ʹ�õĸ�ʽ
     * 
     * @param formater
     *            ���磺"yyyy-MM-dd HH"
     * @return ���ݸ����ĸ�ʽ���ص�ǰϵͳʱ����ַ��� <br/>
     *         ���磺�����ʽΪ "yyyy-MM-dd HH:mm:ss" �򷵻��ַ���Ϊ 2011-07-20 13
     */
    public static String formatTime(final String formater) {
        return formatTime(formater, new Date());
    }

    /**
     * ��ʱ���ʽ��Ϊ�ض��ĸ�ʽ����ʽ�ο� SimpleDateFormat ��ʹ�õĸ�ʽ
     * 
     * @param formater
     *            ���磺"yyyy-MM-dd HH"
     * @param time
     *            ʱ���long��ʽ
     * @return ���ݸ����ĸ�ʽ����time ָ��ʱ����ַ��� <br/>
     *         ���磺�����ʽΪ "yyyy-MM-dd HH" �򷵻��ַ���Ϊ 2011-07-20 13
     */
    public static String formatTime(final String formater, final Long time) {
        return formatTime(formater, new Date(time));
    }

    public static String formatTime(final String formater, final Date date) {
        return new SimpleDateFormat(formater).format(date);
    }

    /**�� 2014��4�� ����һ����2014��3��
     * ��ȡ��һ����
     * @param date ����
     * @return ����
     */
    public static Date getLastMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }
    
    /**
     * ��ȡ��һ��
     * @param date
     * @return
     */
    public static Date getNextMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        return cal.getTime();
    }
    
    /**
     * ��ȡ��һ����
     * @param date ����
     * @return ����
     */
    public static Date getLastYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, -1);
        return cal.getTime();
    }
    
    /**
     * ��ȡ��һ��
     * @param date
     * @return
     */
    public static Date getNextYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, 1);
        return cal.getTime();
    }
    
    /**
     * ��ʽ��ʱ��\/Date(1391961600000+0800)\/
     * 
     * @param time \/Date(1391961600000+0800)\/
     * @return
     */
    public static String formatTimeWhthDateString(String time) {
        time = time.substring(time.indexOf("(") + 1, time.indexOf("+"));
        Date date = new Date(Long.parseLong(time.trim()));
        return formatTime("yyyy-MM-dd HH:mm:ss", date);
    }

    public static String formatDateWhthDateString(String time) {
        time = time.substring(time.indexOf("(") + 1, time.indexOf("+"));
        Date date = new Date(Long.parseLong(time.trim()));
        return formatTime("yyyy-MM-dd", date);
    }
    public static String formatMsgTimeByDateString(String time) {
    	 time = time.substring(time.indexOf("(") + 1, time.indexOf("+"));
         Date date = new Date(Long.parseLong(time.trim()));
         return formatTime("yyyy-MM-dd HH:mm:ss", date).replace(" ", "T");
    }

    public static String formatTimeWhthDateString(String time, final String format) {
        time = time.substring(time.indexOf("(") + 1, time.indexOf("+"));
        Date date = new Date(Long.parseLong(time.trim()));
        return formatTime(format, date);
    }

    public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MM-dd HH:mm");



    /**
     * �ж��ַ����Ƿ�Ϊ��
     * 
     * @param value
     *            String ��Ҫ�жϵ��ַ���
     * @return ��������ַ���Ϊ null ��null�� �� "" ������� false
     */
    public static boolean isNotNull(final String value) {
        return (value != null && !"".equalsIgnoreCase(value));
    }

    /**
     * �ж��ַ����Ƿ�Ϊ��
     * 
     * @param str
     *            String ��Ҫ�жϵ��ַ���
     * @return ��������ַ���Ϊ null ��null�� �� "" ������� true
     */
    public static boolean isNull(final String value) {
        return !isNotNull(value);
    }

    /**
     * �ж�byte ���� �Ƿ�Ϊ��Ϊ��
     * 
     * @param value
     * @return
     */
    public static boolean isNotNull(final byte[] value) {
        return (value != null && value.length != 0);
    }

    /**
     * �ж���ֵ �Ƿ�Ϊ��Ϊ�պ�0
     * 
     * @param value
     * @return
     */
    public static boolean isNotNull(final Double value) {
        return (value != null && value != 0);
    }

    /**
     * �ж���ֵ �Ƿ�ΪΪ��
     * 
     * @param value
     * @return
     */
    public static boolean isNull(final Double value) {
        return !isNotNull(value);
    }

    /**
     * �ж�byte ���� �Ƿ�ΪΪ��
     * 
     * @param value
     */
    public static boolean isNull(final byte[] value) {
        return !isNotNull(value);
    }


    /**
     * �ж������ַ��� equal �Ľ��</br>�����ַ��� ����Ϊ��
     * 
     * @param first
     * @param second
     * @return
     */
    public static boolean isEqual(final String first, final String second) {
        if (isNull(first) && isNull(second)) {
            return true;
        }
        if (!isNull(first) && !isNull(second) && first.equals(second)) {
            return true;
        }
        return false;
    }

    /**
     * @author ltg �ж��ַ����Ƿ��ɴ��������</br>������
     * @param str
     * @return
     */
    public static boolean isNumeric(final String str) {
        if (isNull(str) || str.length() == 0) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static Date formatStringToDate(final String time) {
        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formate.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * �����������
     * 
     * @return
     */
    public static long getRandomId() {
        return RANDOM.nextLong();
    }

    /**
     * ��ȡ�ļ���С�ֽ���
     * 
     * @param filePath
     * @return
     */
    public static long getFileSizeKb(final String filePath) {
        File file = new File(filePath);
        return file.length();
    }
    
    public static Double getFileSizeMB(String filePath) {
    	Double size = 0.0;
		String resource_size = "";
		long length = getFileSizeKb(filePath);
        DecimalFormat df = new DecimalFormat("0.00");
//        if((double)((double)length/1024)>1000){
            resource_size = df.format((double)((double)length/1024/1024));
//        }else{
//            resource_size = df.format((double)((double)length/1024));
//        }
        size = Double.valueOf(resource_size);
        return size;
    	
    }

    /**
     * des �Ƿ�͵�����ͬһ��
     * 
     * @param des
     * @return
     */
    public static boolean isInOneDay(final Date des) {
        return isInOneDay(des, new Date());
    }

    /**
     * one��two�Ƿ���ͬһ��
     * 
     * @param one
     * @param two
     * @return
     */
    public static boolean isInOneDay(final Date one, final Date two) {
        Date a = new Date(one.getTime());
        Date b = new Date(two.getTime());
        a.setHours(1);
        a.setMinutes(1);
        a.setSeconds(1);
        b.setHours(1);
        b.setMinutes(1);
        b.setSeconds(1);
        if (a.after(b) || a.before(b)) {
            return false;
        }
        return true;
    }

    /**
     * ��������ļ���ʽ
     * 
     * @param f
     * @return
     */
    public static String getMIMEType(final File f) {
        String type = "";
        String end = f.getName().substring(f.getName().lastIndexOf(".") + 1, f.getName().length()).toLowerCase();
        if (end.equals("mp3") || end.equals("aac") || end.equals("aac") || end.equals("amr") || end.equals("mpeg")
                || end.equals("mp4") || end.equals("3gp")) {
            type = "audio";
        } else if (end.equals("jpg") || end.equals("gif") || end.equals("png") || end.equals("jpeg")) {
            type = "image";
        } else if (end.equals("txt")) {
            type = "txt";
        } else {
            type = "*";
        }
        type += "/*";
        return type;
    }


    /**
     * �ж��Ƿ�ΪNULL���ǿ��ַ���
     * 
     * @param str
     * @return��ΪNULL���ǿ��ַ���ʱ����true�����򷵻�false
     */
    public static Boolean StrIsNullEmpty(final String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        return false;
    }

    /**
     * ��ȡ�ļ�����
     */
    public static String GetFileName(final String fileurl) {
        if (fileurl == null || fileurl.equals("")) {
            return null;
        }
        int i = fileurl.lastIndexOf('/');
        if (i == -1) {
            i = fileurl.lastIndexOf('\\');
            if (i == -1) {
                return fileurl;
            }
        }
        return fileurl.substring(i + 1);
    }

    /**
     * �ж��ļ��Ƿ����
     * 
     * @param path
     * @return
     */
    public static boolean isExitFile(final String path) {
        if (path == null) {
            return false;
        }
        try {
            File f = new File(path);
            if (!f.exists()) {
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return true;
    }

    /**
     * �ж��ļ����ļ����Ƿ����
     * 
     * @param strfilename
     *            �ļ��������ļ���
     * @return
     */
    public static boolean isExistFolderFromFile(final String strfilename) {
        if (StrIsNullEmpty(strfilename)) {
            return false;
        }
        int index = strfilename.lastIndexOf('/');
        if (index <= 0) {
            return false;
        }
        String fdir = strfilename.substring(0, index);
        return isExistFolder(fdir);
    }

    /**
     * �ж��Ƿ�����ļ���,��������᳥�Խ��д���
     */
    public static boolean isExistFolder(final String strFolder) {
        if (strFolder == null) {
            return true;
        }
        boolean bReturn = false;

        File f = new File(strFolder);
        if (!f.exists()) {
            /* �����ļ��� */
            if (f.mkdirs()) {
                bReturn = true;
            } else {
                bReturn = false;
            }
        } else {
            bReturn = true;
        }
        return bReturn;
    }


    /**
     * �����ļ��Ĵ�С
     * 
     * @param f
     * @return
     * @throws Exception
     */
    // �ݹ�
    public static long getFileSize(final File f) throws Exception {
        if (!f.exists()) {
            return 0;
        }
        long size = 0;
        File flist[] = f.listFiles();
        for (File element : flist) {
            if (element.isDirectory()) {
                size = size + getFileSize(element);
            } else {
                size = size + element.length();
            }
        }
        return size;
    }


    // д���ݵ�SD�е��ļ�
    public static void writeToSdcard(final String fileName, final String write_str) {
        try {

            FileOutputStream fout = new FileOutputStream(fileName);
            byte[] bytes = write_str.getBytes();

            fout.write(bytes);
            fout.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ɾ���ļ�
    public static boolean deleteFile(final String fileName) {
        try {
            File f = new File(fileName);
            return f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * ��֤�ֻ�����
     * 
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(final String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    
    /** 
     * �绰������֤ 
     *  
     * @param  str 
     * @return ��֤ͨ������true 
     */  
    public static boolean isPhone(String str) {   
        Pattern p1 = null,p2 = null;  
        Matcher m = null;  
        boolean b = false;    
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // ��֤�����ŵ�  
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // ��֤û�����ŵ�  
        if(str.length() >9)  
        {   m = p1.matcher(str);  
            b = m.matches();    
        }else{  
            m = p2.matcher(str);  
            b = m.matches();   
        }    
        return b;  
    }  
    
    /**
     * �����̻���֤��׼
     * @param mobiles
     * @return
     */
    public static boolean isPhoneNO(final String mobiles) {
        Pattern p = Pattern.compile("^(\\(\\d{3,4}\\)|\\d{3,4}-?)?\\d{7,8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
    
    /**
	 * ��֤�����ַ�Ƿ���ȷ
	 * @param email
	 * @return ��֤ͨ������true 
	 */
	public static boolean isEmail(String email) {
		boolean isEmail = false;
		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(email);
		isEmail = matcher.matches();
		return isEmail;
	}
    
    
    /**
     * ��ȡspinner�±�λ��
     * @param typeList
     * @param name
     * @return
     */
	 public static int getPositionForSpinner(List<String>typeList, String name) {
		  if(name == null || "".equals(name)) {
			  return -1;
		  }
		  if(typeList.size() > 0) {
			  String typeName = null;
			  for(int i = 0; i < typeList.size(); i++) {
				  typeName = typeList.get(i); 
				  if(name.equals(typeName)){
					  return i;
				  }
			  }
		  }
		  return -1;
	 }
	 
	 /**
     * ��ȡ��ǰʱ��
     * @return
     */
    public static String getCurrentDate(){
    	String transDate = "";
    	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date date = new Date(System.currentTimeMillis());
    	transDate = simpleDateFormat.format(date);
    	return transDate;
    }
    /**
     * ��ȡ��ǰʱ��
     * @return
     */
    public static String getVideoDate(){
        String transDate = "";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        transDate = simpleDateFormat.format(date);
        return transDate;
    }
    
    /**
     * ��ȡ��ǰʱ��
     * @return
     */
    public static String getBillCurrentDate(){
        String transDate = "";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        transDate = simpleDateFormat.format(date);
        return transDate;
    }
    
    /**
     * ��ȡ��ǰʱ��
     * @return
     */
    public static String getBillLast6MonthDate(){
	   Calendar cal = Calendar.getInstance();
       cal.add(Calendar.MONTH, -6);
       Date date = cal.getTime();
       return formatTime("yyyy-MM-dd", date);
    }
    
	/**
     * 2014/3/4 08:06
	 * �Ƚ�ʱ���С
	 * @param firstDate
	 * @param secondDate
	 * @return firstDate > secondDate ����true , ����false
	 */
	public static boolean CompareDate(String firstTime, String secondTime) throws ParseException {
		boolean isAfter = false;
		SimpleDateFormat fmtYmdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fistDate = fmtYmdhms.parse(firstTime);
		Date secondDate = fmtYmdhms.parse(secondTime);
		isAfter = fistDate.after(secondDate);
		return isAfter;
	}
	
	
	
	/**
	 * ��ʽ��С����
	 * @param num
	 * @return
	 */
	public static String FormatNum(double num) {
		String arrearage = new java.text.DecimalFormat("#.0").format(num);
		return arrearage;
	}
	
	 /**
	* @description �����ַ����������ֻ���ȫ���ַ��ĸ���
	* @param s
	* @return
	*/

	public static int getChineseNum(String s) {
		if(Utils.isNull(s)) {
			return 0;
		}
		int num = 0;
		char[] myChar = s.toCharArray();
		for (int i = 0; i < myChar.length; i++) {
			if ((char)(byte)myChar[i] != myChar[i]) {
				num = num + 3;
			}else {
				num++;
			}
		}
		return num;
	}
}
