import java.sql.*;


public class MemberManager {
    public void addMember(String name, int age, String email, String phone, String membershipType) {
        String query = "INSERT INTO members (name, age, email, phone, membership_type) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.setString(5, membershipType);

            pstmt.executeUpdate();
            System.out.println("Member added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMember(int id, String name, int age, String email, String phone, String membershipType) {
        String query = "UPDATE members SET name = ?, age = ?, email = ?, phone = ?, membership_type = ? WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.setString(5, membershipType);
            pstmt.setInt(6, id);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Member updated successfully!");
            } else {
                System.out.println("Member with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMember(int id) {
        String query = "DELETE FROM members WHERE id = ?";

        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Member deleted successfully!");
            } else {
                System.out.println("Member with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewMembers() {
        String query = "SELECT * FROM members";

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") + ", Email: " + rs.getString("email") +
                        ", Phone: " + rs.getString("phone") + ", Membership Type: " + rs.getString("membership_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
