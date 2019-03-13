package com.example.SpringBoot.invoice.nc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import cn.mysteel.util.StringUtils;

public class MoneyCalculateUtils {
	public static final int NUM_SCAL = 0;
	public static final int WEIGHT_SCAL = 4;
	public static final int AMOUNT_SCAL = 2;

	// 所有方法均用静态方法实现，不允许实例化
	// private MoneyCalculateUtils() {}
	/**
	 * 实现浮点数的加法运算功能
	 * @param v1 加数1
	 * @param v2 加数2
	 * @return v1+v2的和
	 */
	public static double add(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).doubleValue();
	}

	/**
	 * 实现浮点数的加法运算功能
	 * @param v1 加数1
	 * @param v2 加数2
	 * @param decimal 保留小数位数
	 * @return v1+v2的和
	 */
	public static String add(String v1, String v2, int decimal) {
		DecimalFormat df = new DecimalFormat(getFormat(decimal)); // 格式化，保留两位小数
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return df.format(b1.add(b2)).toString();
	}

	/**
	 * 实现浮点数的减法运算功能
	 * @param v1 被减数
	 * @param v2 减数
	 * @return v1-v2的差
	 */
	public static double sub(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 实现浮点数的减法运算功能
	 * @param v1 被减数
	 * @param v2 减数
	 * @return v1-v2的差
	 */
	public static String sub(String v1, String v2, int decimal) {
		DecimalFormat df = new DecimalFormat(getFormat(decimal)); // 格式化，保留两位小数
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return df.format(b1.subtract(b2)).toString();
	}

	/**
	 * 实现浮点数的乘法运算功能
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return v1×v2的积
	 */
	public static double multi(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 实现浮点数的乘法运算功能
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return v1×v2的积
	 */
	public static String multi(String v1, String v2, int decimal) {
		DecimalFormat df = new DecimalFormat(getFormat(decimal)); // 格式化，保留两位小数
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return df.format(b1.multiply(b2)).toString();
	}

	public static String multiAmount(String v1, String v2) {
		DecimalFormat formater = new DecimalFormat();
		formater.setMaximumFractionDigits(2);
		formater.setGroupingSize(0);
		formater.setRoundingMode(RoundingMode.FLOOR);
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return formater.format(b1.multiply(b2)).toString();
	}

	/**
	 * 实现浮点数的除法运算功能 当发生除不尽的情况时，精确到小数点以后scale位，后面的位数进行四舍五入。
	 * @param v1 被除数
	 * @param v2 除数
	 * @return v1/v2的商
	 */
	public static double div(String v1, String v2) {
		if (StringUtils.isEmpty(v1) || StringUtils.isEmpty(v2)) {
			return 0;
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, 5, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 实现浮点数的除法运算功能 当发生除不尽的情况时，精确到小数点以后scale位，后面的位数进行四舍五入。
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 表示需要精确到小数点以后几位
	 * @return v1/v2的商
	 */
	public static String div(String v1, String v2, int scale) {
		if (StringUtils.isEmpty(v1) || StringUtils.isEmpty(v2)) {
			return "";
		}
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 提供精确的小数位四舍五入功能
	 * @param v 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static String round(String v, int scale) {
		if (StringUtils.isEmpty(v)) {
			return "";
		}
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(v);
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 获取格式化样式
	 * @param decimal 保留小数位数
	 * @return
	 */
	private static String getFormat(int decimal) {
		StringBuffer returnStr = new StringBuffer("0");
		if (decimal > 0) {
			returnStr.append(".");
		}
		for (int i = 0; i < decimal; i++) {
			returnStr.append("0");
		}

		return returnStr.toString();
	}
	
	/**
	 * 格式化银行账号取后四位
	 * @param account
	 * @return
	 */
	public static String formatAcount(String account)
	{
		String accountSub="";
		try {
			accountSub = account.substring(account.length()-4,account.length());
		} catch (Exception e) {
			e.printStackTrace();
			return accountSub="";
		}
		return accountSub;
	}
	
	public static String formatCurrency(String num, Boolean isHasSymbol) {
		String sign = "";
		if (StringUtils.isTrimEmpty(num)) {
			num = "0";
		}

		if (Double.parseDouble(num) < 0) {
			sign = "-";
			num = num.replaceAll("-", "");
		}
		String strNum = num + "";
		String[] arr1 = strNum.split("\\.");
		boolean hasPoint = false;// 是否有小数部分
		String piontPart = "";// 小数部分
		String intPart = strNum;// 整数部分
		if (arr1.length >= 2) {
			hasPoint = true;
			piontPart = arr1[1];
			intPart = arr1[0];
		}

		String res = "";// 保存添加逗号的部分
		int intPartlength = intPart.length();// 整数部分长度
		int maxcount = intPartlength % 3 == 0 ? intPartlength / 3 : intPartlength / 3 + 1;// 整数部分需要添加几个逗号
		for (int i = 1; i <= maxcount; i++)// 每三位添加一个逗号
		{
			int startIndex = intPartlength - i * 3;// 开始位置
			if (startIndex < 0)// 开始位置小于0时修正为0
			{
				startIndex = 0;
			}
			int endIndex = intPartlength - i * 3 + 3;// 结束位置
			String part = intPart.substring(startIndex, endIndex) + ",";
			res = part + res;
		}
		res = res.substring(0, res.length() - 1);// 去掉最后一个逗号

		if (isHasSymbol == null || isHasSymbol) {
			if (hasPoint) {
				return "￥" + sign + res + "." + piontPart;
			} else {
				return "￥" + sign + res;
			}
		} else {
			if (hasPoint) {
				return sign + res + "." + piontPart;
			} else {
				return sign + res;
			}
		}
	}
	private static String formatNum(String a)
	{
		if (a != null && a.length() > 0)
		{
			char [] chars = a.toCharArray();
			int flag = 0;
			for (char m : chars)
			{
				if (m == '-')
				{
					flag ++;
				}
			}
			
			if (flag%2 == 0)
			{
				a.replace("-", "");
				return a.replace("-","").replace("+", "");
			}
			else
			{
				return "-" + (a.replace("-","").replace("+", ""));
			}
			
		}
		
		return "";
	}
	/**
     * 实现任意多个浮点数的加法运算及格式化功能   
     * @param decimal
     * @param values
     * @return
     * * 作者:李明
	 * 邮箱: 404625273@qq.com
	 * 创建时间：2016年10月9日 下午8:40:14 
     */
    public static String add(int decimal,String... values)
    {
    	BigDecimal returnVal = new BigDecimal("0");
    	for(String v:values){
    		if(!StringUtils.isNotEmpty(v))	v="0";
    		v = formatNum(v);
    		returnVal=returnVal.add(new BigDecimal(v));
    	}
    	DecimalFormat df = new DecimalFormat(getFormat(decimal)); //格式化，保留decimal位小数,比如2
    	return df.format(returnVal);  
    }
}