package diherror.src.model;

public class Member {
    private String id;
    private String nama;
    private String jenisMemberId;
    private JenisMember jenisMember;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public String getJenisMemberId() {
        return jenisMemberId;
    }

    public void setJenisMemberId(String jenisMemberId) {
        this.jenisMemberId = jenisMemberId;
    }

    public void setJenisMember(JenisMember jenisMember) {
        this.jenisMember = jenisMember;
    }

    public JenisMember getJenisMember() {
        return jenisMember;
    }
}
