public class OOP_2_1_tehtava1{

    public static void main(String[] args){
        TelevisionViewer homer = new TelevisionViewer();
        homer.run();
    }
}

class Television{
    int channel = 1;
    int channelsOnTv = 10;

    boolean isOn = false;
    
    Television(int i){
        channel = i;
    }

    Television(){
    }

    void setChannel(int i){
        if (channel >= 10)
            channel = 1;
        else
            channel = i;
    }

    int getChannel(){
        return channel;
    }

    void nextChannel(){
        channel = (channel+1 <= channelsOnTv) ? channel+1 : 1;
    }

    void pressOnOff(){
        isOn = !isOn;
    }

    boolean isOn(){
        return isOn;
    }

}

class TelevisionViewer {

    TelevisionViewer(){}

	void run() {
		Television myTV = new Television();
		myTV.setChannel(1);

		for (int day = 1; day <= 10; day++) {
			System.out.println("Woke up, day " + day);

			boolean tired = false;

			if (!myTV.isOn())
				myTV.pressOnOff();

			while (!tired) {
				System.out.println("Watching channel " + myTV.getChannel());
				myTV.setChannel(myTV.getChannel() + 1);
				if (myTV.getChannel() % 4 == 0)
					tired = true;
			}

			myTV.pressOnOff();

			System.out.println("Falling asleep");
		}
	}
}

