package Sort;

/** Created by haisen on 2019/10/8. */
public class Sort {

  public int[] maopao(int[] sort) {
    for (int i = sort.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (sort[j] > sort[j + 1]) {
          int tmp = sort[j];
          sort[j] = sort[j + 1];
          sort[j + 1] = tmp;
        }
      }
    }
    return sort;
  }

  public int[] quick(int[] sort, int left, int right) {
    if (left < right) {
      int index = quicksort(sort, left, right);
      quick(sort, left, index - 1);
      quick(sort, index + 1, right);
    }
    return sort;
  }

  private static int quicksort(int[] sort, int left, int right) {
    int flag = sort[left];
    int l = left;
    int r = right;
    while (l < r) {
      while (sort[r] > flag && l <= r) {
        r--;
      }
      sort[l] = sort[r];
      while (sort[l] < flag && l <= r) {
        l++;
      }
      sort[r] = sort[l];
    }
    sort[l] = flag;
    return l;
  }

  public static int[] guibing(int[] sort) {
    if (sort.length > 1) {
      int mid = (int) sort.length / 2;
      int[] left = new int[mid];
      System.arraycopy(sort, 0, left, 0, left.length);
      int[] right = new int[sort.length - mid];
      System.arraycopy(sort, mid, right, 0, right.length);
      return megin(guibing(left), guibing(right));
    } else {
      return sort;
    }
  }

  public static int[] megin(int[] left, int[] right) {
    int[] sort = new int[left.length + right.length];
    int i = 0;
    int j = 0;
    int pos = 0;
    while (i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        sort[pos++] = left[i++];
      } else {
        sort[pos++] = right[j++];
      }
    }
    if (i != left.length) {
      System.arraycopy(left, i, sort, pos, left.length - i);
    } else {
      System.arraycopy(right, j, sort, pos, right.length - j);
    }
    return sort;
  }

  public static void shell(int[] sort) {
    int length = sort.length;
    length = length / 2;
    while (length >= 1) {
      for (int i = length; i < sort.length; i++) {
        int num = sort[i];
        int j = i - length;
        while (j >= 0 && num < sort[j]) {
          int tmp = sort[j + length];
          sort[j + length] = sort[j];
          sort[j] = tmp;
          j = j - length;
        }
      }
      length = length / 2;
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 4, 6, 2, 5, 3, 7, 9, 8};
    shell(a);
    for (int i : a) System.out.println(i);
  }
}
