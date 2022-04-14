class ReachingPoint{
   public boolean reachingPoints(int sx, int sy, int tx, int ty) {
	while (tx > sx || ty > sy) {
		if (tx < sx || ty < sy) return false;            
		if (ty > tx) {
			if (sx == tx) {
				return (ty - sy) % tx == 0;
			}  
			ty -= (ty / tx) * tx;
		} else {
			if (sy == ty) {
				return (tx - sx) % ty == 0;
			}
			tx -= (tx / ty) * ty;
		}
	}
	return tx == sx && ty == sy;
}
}