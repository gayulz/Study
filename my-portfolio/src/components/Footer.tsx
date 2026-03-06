import { Heart } from "lucide-react";

/**
 * [NEW] Footer - 푸터 컴포넌트
 * 본문 컨텐츠 (lg:pl-64) 크기에 맞춰서 하단에 간결하게 표시됩니다.
 *
 * @author gayul.kim
 * @since 2025-03-06
 */
export default function Footer() {
	return (
		<footer className="w-full bg-[#050505] text-white py-12 border-t border-gray-900 mt-auto">
			<div className="max-w-[1200px] mx-auto px-4 sm:px-6 lg:px-8 text-center flex flex-col items-center justify-center space-y-4">
				<h3 className="text-2xl font-bold font-display tracking-tighter text-white">
					Thank you for visiting!
				</h3>
				<p className="text-gray-400 text-sm max-w-lg mx-auto leading-relaxed">
					"고객의 불편을 해결하던 서비스맨에서, 시스템의 문제를 해결하는 개발자로"<br />
					문제를 두려워하지 않고 원인을 찾아 끝까지 파고듭니다.
				</p>
				<div className="flex items-center justify-center space-x-2 pt-6 border-t border-gray-900 w-full max-w-md mx-auto text-xs text-gray-500 font-mono tracking-widest uppercase">
					<p>Crafted with</p>
					<Heart size={12} className="text-hot-pink animate-pulse" />
					<p>by gayul.kim</p>
				</div>
			</div>
		</footer>
	);
}
