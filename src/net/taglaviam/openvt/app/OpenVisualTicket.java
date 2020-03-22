package net.taglaviam.openvt.app;

import net.taglaviam.openvt.core.bootstrap.TicketManagerSetProvider;
import net.taglaviam.openvt.core.configuration.GenericIspObjectPointerBuilder;
import net.taglaviam.openvt.core.configuration.IspObjectPointer;
import net.taglaviam.openvt.visual.GenericTicket;
import net.taglaviam.openvt.visual.GenericTicketCreator;

import java.util.stream.Collectors;

public final class OpenVisualTicket {

    @IspObjectPointer(file = "/tmp/myconf.ovts")
    private static class MyConfig {
        private String aa;
        private String ba;
        private String nh;

        public String getAa() {
            return aa;
        }

        public void setAa(String aa) {
            this.aa = aa;
        }

        public String getBa() {
            return ba;
        }

        public void setBa(String ba) {
            this.ba = ba;
        }

        public String getNh() {
            return nh;
        }

        public void setNh(String nh) {
            this.nh = nh;
        }
    }

    public static void main(final String[] args) {
        //final var my = new GenericIspObjectPointerBuilder().buildWith(new MyConfig(), MyConfig.class);
        final var set = new TicketManagerSetProvider().setup();
        final var res = set.parallelStream()
                .map(s -> new GenericTicketCreator().create(() -> new GenericTicket(s)))
                .collect(Collectors.toSet());

        res.size();
        set.size();
    }
}
