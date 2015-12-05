import com.sun.org.apache.bcel.internal.generic.PUSH;

import jdk.nashorn.internal.runtime.FindProperty;

public class SLItemList {
//	h𝑒𝑎𝑑𝑒𝑟: 𝐼𝑡𝑒𝑚
//	initially its 𝑛𝑒𝑥𝑡 attribute points to itself
//	// can be used to store sentinel when searching list
	SItem header;
//	𝑝𝑢𝑠h𝐹𝑟𝑜𝑛𝑡(𝑢𝑖𝑑: 𝑠𝑡𝑟𝑖𝑛𝑔, 𝑐𝑖𝑑: 𝑛𝑢𝑚𝑏𝑒𝑟)
//	Inserts new item 𝑖𝑡 at the beginning of list; 
//	𝑖𝑡. 𝑢𝑠𝑒𝑟𝐼𝑑 ≔ 𝑢𝑖𝑑
//	𝑖𝑡. 𝑐𝑢𝑠𝑡𝑜𝑚𝑒𝑟𝐼𝑑 ≔ 𝑐𝑖𝑑
	void pushFront(String uid, int cid){
		header.userId = uid;
		header.customerId = cid;
	}
//	𝑓𝑖𝑛𝑑(𝑢𝑖𝑑: 𝑠𝑡𝑟𝑖𝑛𝑔)
//	returns the item with 𝑖𝑡𝑒𝑚. 𝑢𝑠𝑒𝑟𝐼𝑑 = 𝑢𝑖𝑑
//	// if using sentinel in header, returning header means uid was not found
	void find(String uid){
		
	} 
}
