package les.util;

public class FormataString {
	public static void addString(StringBuilder sb, String msg){
		if(sb.length() != 0){
			sb.append("\n");
		}
		sb.append(msg);
	}

}
