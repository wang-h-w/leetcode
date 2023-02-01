import java.util.Map;
import java.util.HashMap;

class DecodeMessage {
	public String decodeMessage(String key, String message) {
		Map<Character, Character> map = new HashMap<>();
		int flag = 0;
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			if (c == ' ') continue;
			if (!map.containsKey(c)) map.put(c, (char)('a' + flag++));
			if (flag > 26) break;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			if (c == ' ') sb.append(' ');
			else sb.append(map.get(c));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		DecodeMessage dm = new DecodeMessage();
		System.out.println(dm.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
	}
}