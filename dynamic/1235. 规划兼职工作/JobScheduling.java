import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class JobScheduling {
	public int jobScheduling(int[] st, int[] et, int[] ps) {
        int n = st.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new int[]{st[i], et[i], ps[i]});
        Collections.sort(list, (a, b)->a[1] - b[1]);
        int[] f = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            int[] info = list.get(i - 1);
            int a = info[0], b = info[1], c = info[2];
            f[i] = Math.max(f[i - 1], c);
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid)[1] <= a) l = mid;
                else r = mid - 1;
            }
            if (list.get(r)[1] <= a) f[i] = Math.max(f[i], f[r + 1] + c);
        }
        return f[n];
    }

	public static void main(String[] args) {
		JobScheduling job = new JobScheduling();
		System.out.println(job.jobScheduling(new int[] {1,2,3,3}, new int[] {3,4,5,6}, new int[] {5,1,4,7}));
		System.out.println(job.jobScheduling(new int[] {1,2,3,4,6}, new int[] {3,5,10,6,9}, new int[] {20,20,100,70,60}));
		System.out.println(job.jobScheduling(new int[] {1,1,1}, new int[] {2,3,4}, new int[] {5,6,4}));
	}
}