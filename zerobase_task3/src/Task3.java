import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Pager {
    int totalPage;
    int pageBlock;
    int pageIndex;

    public Pager(int totalPage, int pageBlock, int pageIndex) {
        this.totalPage = totalPage;
        this.pageBlock = pageBlock;
        this.pageIndex = pageIndex;
    }

    private int currentBlock() {
        return (pageIndex - 1) / pageBlock;
    }
    public int lastIndex() {
        return (int) (Math.ceil(totalPage / pageBlock)) + 1;
    }
    private int firstNo() {
        return currentBlock() * pageBlock + 1;
    }
    private int lastNo() {
        return currentBlock() * pageBlock + pageBlock;
    }

    public StringBuffer print() {
        StringBuffer pageNavigation = new StringBuffer();

        pageNavigation.append("<a href=\"#\">[&#52376;&#51020;]</a> ").append("<a href=\"#\">[&#51060;&#51204;]</a> ");

        for (int i = firstNo(); i <= lastNo(); i++) {
            if (i > lastIndex() ) {
                continue;
            }

            if (i == pageIndex) {
                pageNavigation.append("<a href=\"#\" class=\"on\" style=\"color:red;\"/>").append(i).append("</a> ");
            } else {
                pageNavigation.append("<a href=\"#\">"+i+"</a> ");
            }
        }

        pageNavigation.append("<a href=\"#\">[&#45796;&#51020;]</a> ").append("<a href=\"#\">[&#47560;&#51648;&#47561;]</a><br>\r\n");

        return pageNavigation;
    }
}

public class Task3 {
    public static void main(String[] args) {
        try {
            File file = new File("index3.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            Pager pager = new Pager(127, 10, 1);
            for (int i = pager.pageIndex; i <= pager.lastIndex(); i++) {
                writer.write(new String(pager.print()));
                pager.pageIndex++;
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

