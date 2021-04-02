package programming_with_classes.tour_agency;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Agency {
    private TravelVoucher[] vouchers = new TravelVoucher[9];
    private final Type[] types = Type.values();
    private final Place[] places = Place.values();
    private final Scanner scanner = new Scanner(System.in);
    private TravelVoucher voucher;

    public void initialization() {
        TravelVoucher[] vouchers = createVouch();
        outPutVouch(vouchers);
        System.out.println("enter 1-sort, 2 choose");
        switch (scanner.nextInt()) {
            case 1 -> {
                sortVoucher(vouchers);
                voucher = chooseVoucher(vouchers);
            }
            case 2 -> voucher = chooseVoucher(vouchers);
        }
        System.out.println(voucher);
        chooseCountOfDay(voucher);
        chooseTransport(voucher);
        chooseFeeding(voucher);
        System.out.println("you Travel : " + voucher);

    }

    public void outPutVouch(TravelVoucher[] vouchers) {
        for (int i = 0; i < vouchers.length; i++) {
            System.out.println(i + " : " + vouchers[i]);
        }

    }

    public TravelVoucher[] createVouch() {
        int count = 9;
        vouchers = new TravelVoucher[count];
        for (int i = 0; i < vouchers.length; i++) {
            Type type = types[(int) (Math.random() * types.length)];
            Place place = places[(int) (Math.random() * places.length)];
            vouchers[i] = new TravelVoucher(type, place);
//            System.out.println(i + " : " + vouchers[i]);
        }


        return vouchers;
    }

    public TravelVoucher chooseVoucher(TravelVoucher[] travelVouchers) {
        System.out.println("\nchoose num of voucher");
        return travelVouchers[scanner.nextInt()];
    }

    public TravelVoucher chooseTransport(TravelVoucher travelVoucher) {
        Transport[] transports = Transport.values();
        System.out.println("choose transport:");
        for (int i = 0; i < transports.length; i++) {
            System.out.println(i + " " + transports[i]);
        }
        int choose = scanner.nextInt();
        travelVoucher.vehicle = transports[choose];
        System.out.println(travelVoucher);
        return travelVoucher;
    }

    public TravelVoucher chooseFeeding(TravelVoucher travelVoucher) {
        Feeding[] feedings = Feeding.values();
        System.out.println("choose feeding:");
        for (int i = 0; i < feedings.length; i++) {
            System.out.println(i + " " + feedings[i]);
        }
        int choose = scanner.nextInt();
        travelVoucher.feeding = feedings[choose];
        System.out.println(travelVoucher);
        return travelVoucher;
    }

    public TravelVoucher chooseCountOfDay(TravelVoucher travelVoucher) {
        System.out.println("choose count of day");
        travelVoucher.day = scanner.nextInt();
        return travelVoucher;
    }

    public TravelVoucher[] sortVoucher(TravelVoucher[] travelVouchers) {
        System.out.println("choose sort by 1-type or 2-place");
        switch (scanner.nextInt()) {
            case 1 -> {
                Arrays.sort(travelVouchers, new SortbyType());
                outPutVouch(travelVouchers);
                return travelVouchers;
            }
            case 2 -> {
                Arrays.sort(travelVouchers, new SortByPlace());
                outPutVouch(travelVouchers);
                return travelVouchers;
            }
            default -> {
                return travelVouchers;
            }

        }

    }

    class SortbyType implements Comparator<TravelVoucher> {

        @Override
        public int compare(TravelVoucher o1, TravelVoucher o2) {
            if (String.valueOf(o1.type).compareTo(String.valueOf(o2.type)) > 0) {
                return 1;
            }
            if (String.valueOf(o1.type).compareTo(String.valueOf(o2.type)) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    class SortByPlace implements Comparator<TravelVoucher> {

        @Override
        public int compare(TravelVoucher o1, TravelVoucher o2) {
            if (String.valueOf(o1.place).compareTo(String.valueOf(o2.place)) > 0) {
                return 1;
            }
            if (String.valueOf(o1.place).compareTo(String.valueOf(o2.place)) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}

