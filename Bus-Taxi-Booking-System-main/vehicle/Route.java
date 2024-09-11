package vehicle;
class Route{
		String source;
		String destination;
		long startTime;
		long ETA;
		
		Route(String source, String destination, long time){
			this.source = source;
			this.destination = destination;
			this.startTime = time;
			ETA = time + calculateTime(source,destination);
		}
		private int calculateTime(String source,String destination)
		{
			return (int)Math.random()*60 +1;
		}
	}