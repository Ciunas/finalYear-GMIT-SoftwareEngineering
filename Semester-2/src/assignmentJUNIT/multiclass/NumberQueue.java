package assignmentJUNIT.multiclass;

public class NumberQueue {

	public NumberDialed queueHead = null;
	public NumberDialed queueTail = null;
	public boolean numb = false;

	public void insert(NumberDialed number) {
		if (queueHead == null) {
			queueHead = number;
			queueTail = number;
			System.out.println(queueHead);
		} else {
			queueTail.prev = number;
			number.next = queueTail;
			queueTail = number;
		}
	}

	public NumberDialed retrieve() {

		if (queueTail != null && queueTail != queueHead) {
			NumberDialed result = queueHead;
			queueHead.prev.next = null;
			queueHead = result.prev;
			return result;
		} else {
			if (queueTail != null && queueTail == queueHead) {
				NumberDialed result = queueHead;
				queueHead = null;
				queueTail = null;
				return result;
			} else {
				return null;
			}
		}
	}

	public NumberDialed getQueueHead() {
		return queueHead;
	}

	public void setQueueHead(NumberDialed queueHead) {
		this.queueHead = queueHead;
	}

	public NumberDialed getQueueTail() {
		return queueTail;
	}

	public void setQueueTail(NumberDialed queueTail) {
		this.queueTail = queueTail;
	}

	public void printNumbers() {
		NumberDialed temp = queueHead;
		while (temp != queueTail) {
			System.out.println(temp);
			temp = temp.prev;
		}
		// System.out.println(queueTail);
	}

	public NumberQueue() {
		super();
		numb = true;
	}
}