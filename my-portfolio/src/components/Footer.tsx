import { Mail, Github, BookOpen } from "lucide-react";

/**
 * [NEW] Footer - 푸터 컴포넌트
 * 전체 폭으로 확장되며, 간단한 Contact 정보를 표시합니다.
 *
 * @author gayul.kim
 * @since 2025-03-06
 */
export default function Footer() {
	return (
		<footer className="w-full bg-[#050505] text-white border-t border-gray-900">
			<div className="max-w-[1200px] mx-auto px-4 sm:px-6 lg:px-8 py-12">
				<div className="grid grid-cols-1 md:grid-cols-3 gap-8 mb-8">
					{/* 소개 */}
					<div>
						<h3 className="text-2xl font-bold text-hot-pink mb-3">GAYUL KIM</h3>
						<p className="text-gray-400 text-sm leading-relaxed">
							Backend Developer | Java & Spring
						</p>
						<p className="text-gray-500 text-xs mt-2">
							고객의 문제를 해결하던 서비스맨에서,<br />
							시스템의 문제를 해결하는 개발자로
						</p>
					</div>

					{/* Contact 정보 */}
					<div>
						<h4 className="text-lg font-bold mb-4 text-white">CONTACT</h4>
						<ul className="space-y-3">
							<li>
								<a
									href="mailto:gayulz@kakao.com"
									className="flex items-center space-x-2 text-gray-400 hover:text-hot-pink transition-colors text-sm group"
								>
									<Mail size={16} className="group-hover:scale-110 transition-transform" />
									<span>gayulz@kakao.com</span>
								</a>
							</li>
							<li>
								<a
									href="https://github.com/gayulz"
									target="_blank"
									rel="noopener noreferrer"
									className="flex items-center space-x-2 text-gray-400 hover:text-hot-pink transition-colors text-sm group"
								>
									<Github size={16} className="group-hover:scale-110 transition-transform" />
									<span>github.com/gayulz</span>
								</a>
							</li>
							<li>
								<a
									href="https://yurizzy.tistory.com/"
									target="_blank"
									rel="noopener noreferrer"
									className="flex items-center space-x-2 text-gray-400 hover:text-hot-pink transition-colors text-sm group"
								>
									<BookOpen size={16} className="group-hover:scale-110 transition-transform" />
									<span>yurizzy.tistory.com</span>
								</a>
							</li>
						</ul>
					</div>

					{/* 추가 정보 */}
					<div>
						<h4 className="text-lg font-bold mb-4 text-white">INFO</h4>
						<p className="text-gray-400 text-sm leading-relaxed mb-2">
							프로젝트 협업이나 개발 관련 문의가<br />
							있으시면 언제든지 연락 주세요.
						</p>
						<p className="text-gray-500 text-xs">
							보통 24시간 이내에 답변드립니다.
						</p>
					</div>
				</div>

			</div>
		</footer>
	);
}
