package test.endtoend.auctionsniper;

import org.junit.After;
import org.junit.Test;

public class AuctionSniperEndToEndTest {
    private final FakeAuctionServer auction = new FakeAuctionServer("item-54321");
    private final ApplicationRunner application = new ApplicationRunner();

    @Test
    public void sniperJoinsAuctionUntilAuctionCloses() throws Exception {
        auction.startSellingItem();
        System.out.println("1");
        application.startBiddingIn(auction);
        System.out.println("2");
        auction.hasReceivedJoinRequestFromSniper();
        System.out.println("3");
        auction.announceClosed();
        System.out.println("4");
        application.showsSniperHasLostAuction();
        System.out.println("5");
    }

    // Additional cleanup
    @After
    public void stopAuction() {
        auction.stop();
    }

    @After
    public void stopApplication() {
        application.stop();
    }
}
