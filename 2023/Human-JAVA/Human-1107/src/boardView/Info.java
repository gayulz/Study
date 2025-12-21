package boardView;

import Functoins.Functions;
import boardDAO.BoardDAO;
import boardDTO.BoardDTO;

import java.util.ArrayList;

public class Info {
    private Functions fn = new Functions();
    private ArrayList<BoardDTO> postList = null;
    BoardDTO board = null;

    public Info() {
        boolean flag = true;
        while (flag) {
            prtInfo();
            int selnum = Integer.parseInt(fn.retrunText("번호"));
            switch (selnum) {
                case 1: // 글 작성
                    createPost();
                    break;
                case 2: // 글 수정
                    editPost();
                    break;
                case 3: // 글 삭제
                    deletePost();
                    break;
                case 4: // 글 검색
                    postSearch();
                    break;
                case 5: // 전체보기
                    viewAll();
                    break;
                case 6: // 프로그램 종료
                    System.out.println("프로그램을 종료합니다");
                    flag = false;
                    break;
                default:
                    System.out.println("잘못 된 입력 번호 입니다 다시 입력하세요");
            }
        }


    }

    // 게시글 전체보기입니다
    private void viewAll() {
        // 전체 보기 리스트 입니다
        try {
            this.postList = BoardDAO.getPostList("전체보기", 5);
            String check = "";
            if (postList.size() != 0) {
                for (BoardDTO boardDTO : postList) {
                    if (boardDTO.getCheckSecret() == 1) check = "비밀글";
                    else check = "자유글";
                    System.out.println("=================================");
                    System.out.println(String.format("%10s", "작 성 자 : ") + String.format("%-30s", boardDTO.getAuthor()));
                    System.out.println(String.format("%10s", "제   목 : ") + String.format("%-30s", boardDTO.getTitles()));
                    if (check.equals("비밀글"))
                        System.out.println(String.format("%10s", "내   용 : ") + String.format("%-30s", check));
                    else
                        System.out.println(String.format("%10s", "내   용 : ") + String.format("%-30s", boardDTO.getContent()));
                    System.out.println(String.format("%10s", "공개 여부 : ") + String.format("%-30s", check));
                }
            }
        } catch (Exception e) {
            System.out.println("예외 발생");
        } finally {
            System.out.println("초기화면으로 넘어갑니다");
        }
    }


    // 게시글 조회 / Like를 이용하여 제목에 키워드로 검색하기
    private void postSearch() {
        System.out.println("게시글 검색 입니다 , 작성자와 글 내용 중 키워드를 입력하면 됩니다");
        try {
            String keyword = fn.retrunText("검색 키워드");
            this.postList = BoardDAO.getPostList(keyword, 4);
            String check = "";
            if (postList.size() != 0) {
                for (BoardDTO boardDTO : postList) {
                    if (boardDTO.getCheckSecret() == 1) check = "비밀글";
                    else check = "자유글";
                    System.out.println("=================================");
                    System.out.println(String.format("%10s", "작 성 자 : ") + String.format("%-30s", boardDTO.getAuthor()));
                    System.out.println(String.format("%10s", "제   목 : ") + String.format("%-30s", boardDTO.getTitles()));
                    if (check.equals("비밀글"))
                        System.out.println(String.format("%10s", "내   용 : ") + String.format("%-30s", check));
                    else
                        System.out.println(String.format("%10s", "내   용 : ") + String.format("%-30s", boardDTO.getContent()));
                    System.out.println(String.format("%10s", "공개 여부 : ") + String.format("%-30s", check));
                }
            }
        } catch (Exception e) {
            System.out.println("예외 발생");
        } finally {
            System.out.println("초기화면으로 넘어갑니다");
        }
    }

    // 글 삭제 기능
    private void deletePost() {
        try {
            System.out.println("게시글 수정 메뉴 입니다");
            String title = fn.retrunText("검색 제목");
            board = BoardDAO.postSearch(title);
            int cnt = 0;
            while (cnt <= 5) {
                String tmpPass = fn.retrunText("비밀번호");
                if (board.getPassword().equals(tmpPass)) {
                    System.out.println(board.getTitles() + "삭제 하시겠습니까 ?");
                    int selnum = Integer.parseInt(fn.retrunText("삭제 1번 , 취소 2번"));
                    if (selnum == 1) BoardDAO.delete(board);
                    else System.out.println(board.getTitles() + "삭제 취소");
                    break;
                } else {
                    cnt++;
                    System.out.println("다시 입력하세요 [ 시도 횟수 " + cnt + "/ 5 ]");
                }
            }
        } catch (Exception e) {
            System.out.println("예외 발생");
        } finally {
            System.out.println("초기화면으로 넘어갑니다");
        }

    }

    // 게시글 수정
    private void editPost() {
        System.out.println("게시글 수정 메뉴 입니다");
        try {
            String title = fn.retrunText("검색 제목");
            board = BoardDAO.postSearch(title);
            int cnt = 0;
            while (cnt <= 3) {
                String tmpPass = fn.retrunText("비밀번호");
                if (board.getPassword().equals(tmpPass)) {
                    System.out.println("기존 내용 입니다");
                    System.out.println(board.getContent());
                    board.setContent(fn.retrunText("변경할 내용"));
                    BoardDAO.update(board);
                    break;
                } else {
                    cnt++;
                    System.out.println("다시 입력하세요 [ 시도 횟수 " + cnt + "/ 3 ]");
                }
            }
        } catch (Exception e) {
            System.out.println("예외 발생");
        } finally {
            System.out.println("초기화면으로 넘어갑니다");
        }
    }

    // 게시글 작성
    // 작성 로직 : 작성자 / 제목 / 내용 / 비밀번호 / 비밀글체크
    private void createPost() {
        System.out.println("게시글 작성 메뉴 입니다");
        try {
            BoardDTO board = new BoardDTO();
            while (true) {
                if (board.setAuthor(fn.retrunText("작성자"))) {
                    board.setTitles(fn.retrunText("제목"));
                    board.setContent(fn.retrunText("내용"));
                    board.setPassword(fn.retrunText("비밀번호"));
                    if (board.setCheckSecret(Integer.parseInt(fn.retrunText("비밀글 체크( 0 : 전체글 , 1 : 비밀게시 )")))) {
                        BoardDAO.createPost(board);
                        break;
                    }
                } else System.out.println("다시 입력하세요");
            }
        } catch (Exception e) {
            System.out.println("예외 발생");
        } finally {
            System.out.println("초기화면으로 넘어갑니다");
        }
    }

    // 메뉴 출력
    private void prtInfo() {
        System.out.println("문의 게시판 입니다");
        System.out.println("1. 문의 글 작성");
        System.out.println("2. 문의 글 수정");
        System.out.println("3. 글 삭제");
        System.out.println("4. 글 검색");
        System.out.println("5. 전체 글 보기");
        System.out.println("6. 프로그램 종료 ");
    }
}
