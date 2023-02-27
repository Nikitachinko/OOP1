package Transport;
import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation <T extends Transport> {
    private final Queue<T> queue;

    public ServiceStation() {
        queue = new LinkedList<>();
    }

    public void addToQueue(T transport) throws TransportTypeException {
        if(transport==null){
            System.out.println("Error! Transport is NULL");
            return;
        }
        if(transport.diagnostic()) {
            if (queue.offer(transport))
                System.out.println(transport.getBrand() + " " + transport.getModel() + " успешно добавлен в очередь на обслуживание");
            else
                System.out.println("что-то пошло не так с " + transport.getModel() + " " + transport.getModel());
        } else
            System.out.println("Автобусы диагностику не проходят! " + transport.getBrand() + " " + transport.getModel());
    }

    public void makeDiagnostic() {
        T transport = queue.poll();
        if (transport != null) {
            System.out.println(transport.getBrand() + " " + transport.getModel() + " успешно прошел облуживание");
        }else
            System.out.println("Очередь на облуживание пуста");
    }

    @Override
    public String toString() {
        StringBuilder totalTransports = new StringBuilder();
        int count = 0;
        if (queue.peek() != null) {
            for (Transport ts: queue) {
                totalTransports.append(" #").append(++count).append(": ").append(ts.getBrand()).append(" ").append(ts.getModel()).append(" ");
            }
        }
        if(count==0)
            return "'Очередь на обслуживиние пуста'";
        return totalTransports.toString();
    }
}
