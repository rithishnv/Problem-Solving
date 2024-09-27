class MyCalendarTwo {
    TreeMap<Integer, Integer> t = new TreeMap<>();

    public MyCalendarTwo() {
    }
    public boolean book(int start, int end) {
        t.put(start, t.getOrDefault(start, 0) + 1);
        t.put(end, t.getOrDefault(end, 0) - 1);
        int c = 0;
        for (int i : t.values()) {
            c += i;
            if (c >= 3) {
                t.put(start, t.getOrDefault(start, 0) - 1);
                t.put(end, t.getOrDefault(end, 0) + 1);
                if (t.get(start) == 0)
                    t.remove(start);
                if (t.get(end) == 0)
                    t.remove(end);
                return false;
            }
        }
        return true;
    }
}