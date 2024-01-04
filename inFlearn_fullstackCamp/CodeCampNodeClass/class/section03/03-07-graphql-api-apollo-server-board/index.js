import { ApolloServer } from "@apollo/server";
import { startStandaloneServer } from "@apollo/server/standalone";

// The GraphQL schema
// 쿼리에 대한 타입을 적겠다 라는 의미
const typeDefs = `#graphql

  input CreateBoardInput {
    writer : String
    title : String
    contents : String 
  }

  type MyResult {
    number : Int
    writer : String
    title : String
    contents : String
  }

  type Query { 
    fetchBoards : [MyResult] 
    # 배열 안에 객체 1개 이상을 의미한다      
  }
  
  type Mutation {
    # createBoard(writer : String, title : String, contents: String!): String
    createBoard(createBoardInput : CreateBoardInput!) : String 
  }
`;
// 리턴타입들은 모두 type으로 해야ㅕ한다
// 만약 매개변수로 들어오는 타입들은 input 으로 명시해야한다
// 필수 입력은 ! 로 명시하면 된다
// A map of functions which return data for the schema.
const resolvers = {
  Query: {
    fetchBoards: (parent, args, context, info) => {
      // 조회하였다는 가정하에 진행한다
      const result = [
        {
          number: 1,
          writer: "김춘식",
          title: "춘식이입니당",
          contents: "냐용냐용냐용냐용",
        },
        {
          number: 2,
          writer: "라이언",
          title: "라이언입니당",
          contents: "어흥어흥어흥어흥",
        },
        {
          number: 3,
          writer: "어피치",
          title: "춘식이입니당",
          contents: "복숭봉숭복숭",
        }
      ];
      return result;
    }
  },

  Mutation: {
    createBoard: (_, args) => {
      //브라우저에서 전송된 데이터 확인하기
      console.log(args.CreateBoardInput.writer);
      console.log(args.CreateBoardInput.title);
      console.log(args.CreateBoardInput.contents);
      console.log("-----------------");

      // db접속 후 데이터를 저장 => 저장 하였다고 가정해 보자
      return "게시물 등록에 성공하였습니다";
    }
  }
}

const server = new ApolloServer({
  /*
    typeDefs : typeDefs,  // 스웨거 부분
    resolvers: resolvers, // API 부분 
    */
  typeDefs,
  resolvers, // shorthand 기법
  cors: true // 모든 사이트 허용
  // cors : {origin : ["https://naver.com", "https://daum.net"]} 특정 사이트만 지정하고 싶을때 함
});

// 기본 포트번호 4000
startStandaloneServer(server);

/*
const { url } = await startStandaloneServer(server);
console.log(`🚀 Server ready at ${url}`);
*/
